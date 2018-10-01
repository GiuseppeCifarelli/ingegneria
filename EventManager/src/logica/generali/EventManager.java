/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generali;
import presentazione.generali.AvvisoErroreCredenziali;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import presentazione.generali.Login;
import javax.swing.JFrame;
import java.io.*;
import java.net.*;
/**
 *
 * @author Dastler
 */
public class EventManager {
    public static void main(String[] args){
       new LoginController();  
    }
}
