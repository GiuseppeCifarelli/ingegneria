package DAO.ImplementazioneDAO;
//import java.io.File;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import DAO.*;
import entita.Eventi;

public class EventiDaoImplementazione implements EventiDAO {

	@Override
	public void Create(Connection con, String nome, String descr, String citta, String categoria, LocalDate data,
			double prezzo, int biglietti, String nomeImmagine) {
		try {
			//settaggio per la data	
			java.sql.Date date = java.sql.Date.valueOf(data);
	
			//settaggio per importare l'immagine
			String path="immaginiEventi\\"+categoria+"\\"+nomeImmagine;
			/*
			char FS=File.separatorChar;
			File file = new File(path + FS +nomeImmagine);
			InputStream fin = new java.io.FileInputStream(file);
			int fileLength = (int)file.length();
			 */
			//preparedStatement per la query
			PreparedStatement prepared = con.prepareStatement("insert into eventi (Nome,Descrizione,Citta,Categoria,Data,Prezzo,BigliettiDisponibili,Immagini,NumeroBigliettiIniziali) values (?,?,?,?,?,?,?,?,?)");
			prepared.setString(1, nome);//nome
			prepared.setString(2, descr);//descrizione
			prepared.setString(3, citta);//citta
			prepared.setString(4, categoria);//categoria
			prepared.setDate(5, date);//data
			prepared.setDouble(6, prezzo);//prezzo
			prepared.setInt(7, biglietti);//biglietti disponibili
			prepared.setString(8, path);//percorso dell'immagine
			prepared.setInt(9, biglietti);//biglietti iniziali
			//prepared.setBinaryStream (8, fin, fileLength);//immagine
			prepared.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public LinkedList<Eventi> Research(Connection con, String nome, String descr, String citta, String categoria, LocalDate data1, LocalDate data2,
			double prezzo, int biglietti) {
		LinkedList<Eventi> listaEventi=new LinkedList<Eventi>();
		try {
			PreparedStatement prepared ;
			ResultSet res;
			
			if(nome.equals("null") && descr.equals("null") && citta.equals("null") && categoria.equals("null") && data1 == null && data2 == null && prezzo==0 && biglietti==0) {
				prepared = con.prepareStatement("select * from eventi ");
				res = prepared.executeQuery();
			}
			else {
				String query="select * from eventi where ";
				boolean queryIsEmpty = true;
				
				
				if(!nome.equals("null")) {
					query = query + "Nome LIKE '%"+nome+"%'";
					queryIsEmpty = false;
				}
				if(!descr.equals("null")) {
					if (queryIsEmpty) {
						query = query + " Descrizione='"+descr+"'";
						queryIsEmpty = false;
					} else query = query + " && Descrizione='"+descr+"'";
				}
				if(!citta.equals("null")) {
					if(queryIsEmpty) {
						query = query + " Citta='"+citta+"'";
						queryIsEmpty = false;						
					}else query = query + " && Citta='"+citta+"'";
				}
				if(!categoria.equals("null")) {
					if(queryIsEmpty) {
						query = query + "Categoria='"+categoria+"'";
						queryIsEmpty = false;
					}else query = query + "&& Categoria='"+categoria+"'";
				}
				if(data1 != null && data2 != null) {
					if(queryIsEmpty) {
						query = query + " (Data BETWEEN '"+data1+"' AND '"+data2 +"')";
						queryIsEmpty = false;
					} else query = query + " && (Data BETWEEN '"+data1+"' AND '"+data2 +"')";
				}else {
					if(data1 != null) {
						if(queryIsEmpty) {
							query = query + " Data >= '"+data1+"'";
							queryIsEmpty = false;
						}else query = query + " && Data >= '"+data1+"'";
					}else if (data2 != null) {
						if(queryIsEmpty) {
							query = query + " Data <= '"+data2+"'";
							queryIsEmpty = false;
						}
					}
				}
				if(prezzo != 0) {
					if(queryIsEmpty) {
						query = query + " Prezzo<='"+prezzo+"'";
						queryIsEmpty = false;
					}else query = query + " && Prezzo<='"+prezzo+"'";
				}
				if(biglietti != 0) {
					if(queryIsEmpty) {
						query = query + " BigliettiDisponibili>='"+biglietti+"'";
						queryIsEmpty = false;
					}else query = query + " && BigliettiDisponibili>='"+biglietti+"'";
				}
				prepared = con.prepareStatement(query);
				res = prepared.executeQuery();
			}
			Eventi temp;
				while (res.next()) {
					temp = new Eventi();
					temp.setNome(res.getString("Nome"));
					temp.setCategoria(res.getString("Categoria"));
					temp.setBiglietti(res.getInt("BigliettiDisponibili"));
					temp.setCitta(res.getString("Citta"));
					temp.setData(res.getDate("Data"));
					temp.setDescr(res.getString("Descrizione"));
					temp.setCodice(res.getInt("Codice"));
					temp.setPrezzo(res.getDouble("Prezzo"));
					temp.setNomeImmagine(res.getString("Immagini"));
					listaEventi.add(temp);
				}
		}catch(SQLException e) {
			System.out.println("Errore query SQL:" + e.getErrorCode());
		}catch(Exception e) {
			System.out.println("Errore funzione ricerca:" + e.getMessage());
			e.printStackTrace();
		}
		return listaEventi;
	}

	@Override
	public void Update(Connection con,  String nome, int codiceUpdate, String descr, String citta, String categoria, LocalDate data,
			double prezzo, int biglietti, String nomeImmagine) {
		try {
			PreparedStatement modify = con.prepareStatement("select NumeroBigliettiIniziali,BigliettiDisponibili from eventi where Codice = ? ");
			modify.setInt(1, codiceUpdate);
			ResultSet modifyControllo = modify.executeQuery();
			int temp_ticketDisponibili = 0, temp_ticketDisposizione = 0;
			while(modifyControllo.next()) {
				temp_ticketDisponibili = modifyControllo.getInt("BigliettiDisponibili");
				temp_ticketDisposizione = modifyControllo.getInt("NumeroBigliettiIniziali");
			}
			if(temp_ticketDisponibili != temp_ticketDisposizione) return; //le modifiche non si possono apportare se sono stati già venduti biglietti
			PreparedStatement prepared = con.prepareStatement("update eventi set Nome=?, Descrizione = ?, Citta=?, Categoria=?,"
					+ "Data=?, Prezzo=?, BigliettiDisponibili=? where Codice = ?");
			prepared.setString(1, nome);//nome
			prepared.setString(2, descr);//descrizione
			prepared.setString(3, citta);//citta
			prepared.setString(4, categoria);//categoria
			//settaggio per la data	
			java.sql.Date date = java.sql.Date.valueOf(data);
			prepared.setDate(5,date);//data
			prepared.setDouble(6, prezzo);//prezzo
			prepared.setInt(7, biglietti);//numero biglietti disponibili
			prepared.setInt(8, codiceUpdate);//codice evento modificato

			prepared.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean Delete(Connection con, int codiceDelete) {
		try {
			PreparedStatement modify = con.prepareStatement("select NumeroBigliettiIniziali,BigliettiDisponibili from eventi where Codice = ? ");
			modify.setInt(1, codiceDelete);
			ResultSet modifyControllo = modify.executeQuery();
			int temp_ticketDisponibili = 0, temp_ticketDisposizione = 0;
			while(modifyControllo.next()) {
				temp_ticketDisponibili = modifyControllo.getInt("BigliettiDisponibili");
				temp_ticketDisposizione = modifyControllo.getInt("NumeroBigliettiIniziali");
			}
			if(temp_ticketDisponibili != temp_ticketDisposizione) return false; //l'evento non si può eliminare se sono stati venduti biglietti
			PreparedStatement prepared = con.prepareStatement("delete from eventi where Codice= ? ");
			prepared.setInt(1, codiceDelete);
			prepared.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
