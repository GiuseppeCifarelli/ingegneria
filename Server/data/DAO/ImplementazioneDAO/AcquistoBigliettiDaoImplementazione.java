package DAO.ImplementazioneDAO;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import DAO.AcquistoBigliettiDAO;
import entita.AcquistoBiglietti;

public class AcquistoBigliettiDaoImplementazione implements AcquistoBigliettiDAO {

	@Override
	public void Create(Connection con, int codiceCL, int codiceEv, int numBiglietti) {
		try {
			Statement stm = con.createStatement();
			//prendo il codice dell'evento che il cliente vuole prendere i biglietti
			ResultSet rs = stm.executeQuery("select Codice,BigliettiDisponibili from eventi where Codice='"+codiceEv+"'");
			int codiceEvento=0, bigliettiTotali=0;
			while (rs.next()) {
				codiceEvento = rs.getInt("Codice");
				bigliettiTotali = rs.getInt("BigliettiDisponibili");
			}
			if (bigliettiTotali == 0 || bigliettiTotali < numBiglietti) {
				System.out.println("Biglietti non disponibili");
			} else {				
				//settaggio per importare l'immagine, da cambiare con il codice per la generazione di qrcode
				String nameQr =codiceCL+"_"+codiceEvento;
				GeneraQRCode objqr = new GeneraQRCode();
				objqr.generaQR(nameQr);
				String path = "A:\\Universita\\INGSFW\\Documentazione\\Codice\\Server\\Server\\images\\"+nameQr+".jpg";
				File file = new File (path);
				org.apache.commons.io.FileUtils.copyFile(file, new File ("C:\\Users\\Giuseppe\\eclipse-workspace\\Sito\\WebContent\\QRCode\\"+nameQr+".jpg"),true);
				
				InputStream fin = new java.io.FileInputStream(file);
				int fileLength = (int)file.length();
			
				PreparedStatement prepared = con.prepareStatement("insert into acquistobiglietti (CodiceEvento, CodiceCliente, NBiglietti,QRCode) values (?,?,?,?)");
				prepared.setInt(1, codiceEvento);//CodiceAcquisto
				prepared.setInt(2, codiceCL);//CodiceCliente
				prepared.setInt(3, numBiglietti );//biglietti acquistati
				prepared.setBinaryStream (4, fin, fileLength);//QRCode
				prepared.executeUpdate();
			
				//modificare il numero di posti disponibili per l'evento, togliendo quelli già venduti
				PreparedStatement modificaPosti = con.prepareStatement("update eventi set BigliettiDisponibili = ? where Codice = ?");
				modificaPosti.setInt(1, bigliettiTotali - numBiglietti );
				modificaPosti.setInt(2, codiceEvento);
				modificaPosti.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<AcquistoBiglietti> Research(Connection con, int codiceCL, int codiceEv) {
		LinkedList<AcquistoBiglietti> buy = new LinkedList<>();
		AcquistoBiglietti temp = null;
		try {
			ResultSet rs;
			Statement stm = con.createStatement();
			if(codiceEv != -1) rs = stm.executeQuery("select *  from acquistobiglietti where CodiceCliente="+codiceCL+"&&CodiceEvento="+codiceEv);
			else rs = stm.executeQuery("select *  from acquistobiglietti where CodiceCliente="+codiceCL);
			while (rs.next()) {
				temp = new AcquistoBiglietti();
				temp.setCodiceAcquisto(rs.getInt("CodiceAcquisto"));
				temp.setCodiceCliente(rs.getInt("CodiceCliente"));
				temp.setCodiceEvento(rs.getInt("CodiceEvento"));
				temp.setNomeFileQr(null);
				temp.setNumBiglietti(rs.getInt("NBiglietti"));
				buy.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buy;
	}

	@Override
	public void Update(Connection con, int codiceCL, int codiceEv) {}

	@Override
	public void Delete(Connection con, int codiceCL, int codiceEv) {}

}
