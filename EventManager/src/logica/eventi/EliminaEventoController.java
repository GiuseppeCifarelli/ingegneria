/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eventi;

import data.Eventi;
import java.io.IOException;
import logica.generali.doConnection;
import presentazione.eventi.EliminaEvento;

/**
 *
 * @author Dastler
 */
public class EliminaEventoController {
    javax.swing.JFrame frame;
    
    public EliminaEventoController(Eventi evento,javax.swing.JFrame risRicercaFrame){
        frame=new EliminaEvento(evento,this,risRicercaFrame);
        frame.setVisible(true);
    }
    
    public boolean eseguiEliminazione(Integer codEvento) throws IOException{
        doConnection.out.println(4);
        doConnection.out.println(codEvento);
        String ok;
        while((ok=doConnection.in.readLine())==null);
            if(ok.equals("Errore")) return false;
            return true;    
    }
}
