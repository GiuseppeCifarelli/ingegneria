/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generali;
import javax.swing.JDialog;
import presentazione.generali.Home;
import javax.swing.JFrame;
import presentazione.generali.Login;
import presentazione.generali.AvvisoErroreCredenziali;
import logica.generali.doConnection;
/**
 *
 * @author Dastler
 */
public class HomeController {
    
    public HomeController(){
       new Home().setVisible(true);
        
    }
}
