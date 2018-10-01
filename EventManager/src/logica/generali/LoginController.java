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
    private Login lFrame;
    public LoginController(){
        lFrame=new Login(this);
        lFrame.setVisible(true);
    }
}
