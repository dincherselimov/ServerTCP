package com.server;
import org.w3c.dom.ls.LSOutput;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.*;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
try {
    ServerSocket serverSocket = new ServerSocket(80);

    //returns the socket and establish a connection between server and client.
    Socket socket = serverSocket.accept();

    //returns the InputStream attached with this socket.
    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

    String str = (String) dataInputStream.readUTF();

    //print a message
    System.out.println("Message" + str);
    //close the socket
    serverSocket.close();
} catch (Exception e) {
    e.printStackTrace();
}
    }

}

