/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siliprandi.diego
 */
public class pongeServer {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(550);
            
            Socket client = server.accept();
            InputStream input = client.getInputStream();
            
            ObjectInputStream IS = new ObjectInputStream(input);
            
            char[] mess = (char[]) IS.readObject();
            
            System.out.println(mess[0]);
            
        } catch (IOException ex) {
            Logger.getLogger(pongeServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pongeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
