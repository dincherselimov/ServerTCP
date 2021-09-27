package com.server;

import ServerSideMethods.ClientHandler;
import java.io.*;
import java.net.*;

/**
 * The ServerTCP class makes a connection with host 127.0.0.1 on port 80(what we have defined in config.properties)
 * Opens a connection and communicates with the client
 * The server accepts the information sent by the client
 */
public class ServerTCP {
    public static void main(String[] args) throws IOException {

        //waiting for a request on port(for example 93)
        ServerSocket socket = new ServerSocket(93);

            while (true) {
                //establish connection
                Socket client = socket.accept();
                System.out.println("Successful");

                //use separate threads
                ClientHandler clientThread = new ClientHandler(client,args[0]);
                new Thread(clientThread).start();

        }

    }
}












































//
//try {
//        //connect to socket on host "localhost" and port 80
//        ServerSocket serverSocket = new ServerSocket(Config.getInstance().getPort());
//
//        //returns the socket and establish a connection between server and client.
//        Socket socket = serverSocket.accept();
//
//        //returns the InputStream attached with this socket.
//        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//
//        String str = (String) dataInputStream.readUTF();
//
//        //print a message
//        System.out.println("Message" + " " +  str);
//        //close the socket
//        serverSocket.close();
//        }
//        catch (Exception e) {
//        e.printStackTrace();
//        }
//        }