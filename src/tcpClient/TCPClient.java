/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpClient;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fadi Asad
 */
public class TCPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        try (Socket clientSocket = new Socket("localhost", 3962)) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + "\n");
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER:" + modifiedSentence);
        } catch (IOException ex) {
            System.err.println(ex.getClass().getName() + ":::" + ex.getMessage() + "\n");
        }
    }

}
