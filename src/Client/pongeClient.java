/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siliprandi.diego
 */
public class pongeClient {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertura connessione");
        
        try {
            Socket server = new Socket("127.0.0.1", 550);
            
            char[] list = new char[10];
            Random r = new Random();
            
            for (int i=0; i<list.length; i++) {
                char a = (char) (r.nextInt(26) + 'a');
                list[i] = a;
                System.out.print(list[i]+" ");
            }
            
            OutputStream OS =  server.getOutputStream();
            ObjectOutputStream OOS = new ObjectOutputStream(OS);
            
            OOS.writeObject(list);
            
            server.close();
            System.out.println("\nChiusura connessione");
            
        } catch (IOException ex) {
            Logger.getLogger(pongeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
