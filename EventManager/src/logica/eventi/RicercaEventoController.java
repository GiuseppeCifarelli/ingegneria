/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eventi;
import java.io.IOException;
import java.util.Date;
import javax.swing.JFrame;
import logica.generali.doConnection;
import presentazione.eventi.RicercaEvento;
import data.Eventi;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import presentazione.eventi.RisultatiRicerca;
/**
 *
 * @author Dastler
 */
public class RicercaEventoController {
    private JFrame RicFrame;
    public RicercaEventoController(){
        RicFrame=new RicercaEvento(this);
        RicFrame.setVisible(true);
    }
    
    public void eseguiRicerca(String name,String descrizione,String citta,String dal,String al,String categoria, Float prezzo,Integer nBiglDisponibili, String imge) throws IOException{
        doConnection.out.println(2);
        doConnection.out.println(dal);
        doConnection.out.println(al);
        doConnection.out.println(name);
        doConnection.out.println(descrizione);
        doConnection.out.println(citta);
        doConnection.out.println(categoria);
        doConnection.out.println(prezzo);
        doConnection.out.println(nBiglDisponibili);
        String ok=null;
        String tmp=null;
        String nom=null;
        String des=null,cit=null,cat=null,da=null,a=null,img=null;
        int nbigliett=0;
        int size;
        int i;
        float pre=0;
        ArrayList<Eventi> list;
        while((ok=doConnection.in.readLine())==null);
        if(ok.equals("Errore")) return ;
        else{ 
            while(!(doConnection.in.readLine().equals("ok1")));
            size=Integer.parseInt(doConnection.in.readLine());
                list=new ArrayList<>(size);
                for(i=0; i<size; i++) list.add(i,new Eventi());
                for(Eventi j: list){
                    j.setCodice(Integer.parseInt(doConnection.in.readLine()));
                    j.setNome(doConnection.in.readLine());
                    j.setDescr(doConnection.in.readLine());
                    j.setCitta(doConnection.in.readLine());
                    j.setCategoria(doConnection.in.readLine());
                    j.setData(doConnection.in.readLine());
                    j.setPrezzo(Float.parseFloat(doConnection.in.readLine()));
                    j.setBiglietti( Integer.parseInt(doConnection.in.readLine()));
                    j.setNomeImmagine(doConnection.in.readLine());
                    doConnection.in.readLine();
                }
                DefaultTableModel model=createModel(list);
                new RisultatiRicerca(model,list).setVisible(true);
            }
    }
    private DefaultTableModel createModel(ArrayList<Eventi> list){
        DefaultTableModel model;
        int i=0;
        Object[][] o=new Object[list.size()][8];
        String []col=new String [] {"Codice","Nome","Descrizione", "Categoria", "Data", "Città ", "Prezzo"," Biglietti",};
        
        for(Eventi e:list){
            o[i][0]=e.getCodice();
            o[i][1]=e.getNome();
            o[i][2]=e.getDescr();
            o[i][3]=e.getCategoria();
            o[i][4]=e.getData();
            o[i][5]=e.getCitta();
            o[i][6]=e.getPrezzo();
            o[i][7]=e.getBiglietti();
            i++;
        }
        model = new DefaultTableModel(o, col){
          boolean [] canEdit=new boolean[]{ false,false,false,false,false,false,false,false};
          
          @Override
          public boolean isCellEditable(int rowIndex,int columnIndex){
              return canEdit[columnIndex];
          }
        };
        
        return model;
    }
}
    

