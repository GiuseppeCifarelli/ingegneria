/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generali;
import presentazione.generali.Login;
import presentazione.generali.AvvisoErroreCredenziali;
import javax.swing.JFrame;

/**
 *
 * @author Dastler
 */
public class LoginController{
    public LoginController(){
        new Login(this).setVisible(true);
    }
    public boolean conn(String user, String pasw){
        return new doConnection().connetti(user,pasw);
         
    }
}
