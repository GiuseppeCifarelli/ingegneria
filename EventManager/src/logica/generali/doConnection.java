/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generali;
import java.io.*;
import java.net.*;
import presentazione.generali.AvvisoErroreCredenziali;
import presentazione.generali.Login;
import presentazione.generali.Home;
/**
 *
 * @author Dastler
 */
public class doConnection {
     public static Socket socket=null;
     public static BufferedReader in=null, stdIn=null;
     public static PrintWriter out=null;
    public doConnection(){
       
    }
    public boolean connetti(String user, String pwd){
        try
            {
                // open a socket connection
                socket = new Socket("localhost", 8081);
			 System.out.println("EchoClient: started");
			 System.out.println("Client Socket: "+ socket);
			 // creazione stream di input da socket
			 InputStreamReader isr = new InputStreamReader( socket.getInputStream());
			 in = new BufferedReader(isr);
			 // creazione stream di output su socket
			 OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
			 BufferedWriter bw = new BufferedWriter(osw);
			 out = new PrintWriter(bw, true);
			 		
			 	 //specifico applicativo
				 out.println("Applicativo");
				 while(!(in.readLine().equals("ok")));
				 //login
                                 System.out.println(user);
                                 System.out.println(pwd);
                                 out.println(user);
				 out.println(pwd);
                                 boolean  ret=in.readLine().equals("ok");
                                 return ret;
            }
            catch(Exception e) { System.out.println(e.getMessage());}
        return false;
   }
   
}
