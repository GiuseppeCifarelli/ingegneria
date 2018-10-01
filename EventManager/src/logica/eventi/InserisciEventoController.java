/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eventi;

import javax.swing.JFrame;
import presentazione.eventi.InserisciEvento;
import data.Categorie;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.generali.doConnection;

/**
 *
 * @author Dastler
 */
public class InserisciEventoController {
    private JFrame InsFrame;
    public InserisciEventoController(){
        InsFrame=new InserisciEvento(this);
        InsFrame.setVisible(true);
    }
    
    public boolean eseguiInserimento(String name,String descrizione,String citta,String data,String categoria, String prezzo,int nBiglDisponibili, String nomeImg) throws IOException{
        doConnection.out.println(1);
        doConnection.out.println(data);
        doConnection.out.println(name);
        doConnection.out.println(descrizione);
        doConnection.out.println(citta);
        doConnection.out.println(categoria);
        doConnection.out.println(new Float(prezzo));
        doConnection.out.println(nBiglDisponibili);
        doConnection.out.println(nomeImg);
        String ok;
        while((ok=doConnection.in.readLine())==null);
        if(ok.equals("ok"))return true;
        return false;
    }
   
}
