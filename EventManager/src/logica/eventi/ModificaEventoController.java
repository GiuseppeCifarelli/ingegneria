/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eventi;

import data.Eventi;
import java.io.IOException;
import java.text.ParseException;
import logica.generali.doConnection;
import logica.generali.doConnection;
import presentazione.eventi.ModificaEvento;

/**
 *
 * @author Dastler
 */
public class ModificaEventoController {
    javax.swing.JFrame frame;
    public ModificaEventoController(Eventi evento,javax.swing.JFrame ricercaFrame) throws ParseException{
        frame=new ModificaEvento(evento,this,ricercaFrame);
        frame.setVisible(true);
    }
    public boolean eseguiModifica(String name,int cod,String descrizione,String citta,String data,String categoria, Float prezzo,int nBiglDisponibili,String ImgPath) throws IOException{
        doConnection.out.println(3);
        doConnection.out.println(data);
        doConnection.out.println(name);
        doConnection.out.println(cod);
        doConnection.out.println(descrizione);
        doConnection.out.println(citta);
        doConnection.out.println(categoria);
        doConnection.out.println(prezzo);
        doConnection.out.println(nBiglDisponibili);
        doConnection.out.println(ImgPath);
        String ok;
        while((ok=doConnection.in.readLine())==null);
            if(ok.equals("Errore"))return false;
            return true;
    }
    
}
