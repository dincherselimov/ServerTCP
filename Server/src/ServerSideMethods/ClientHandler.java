package ServerSideMethods;

import java.io.*;
import java.net.Socket;

/**
 * This class handles multiple client connection using Threads(which implements class Runnable)
 */
public class ClientHandler extends Thread {

    private AcceptFiles fh;
    private SearchInFile sf;
    private final Socket client;
    private String arg;
    //private final SearchString searchString;

    public ClientHandler(Socket socket, String arg) throws IOException {
        this.arg = arg;
        this.client = socket;
        if(arg.equals("1")){
            String location = "D:\\Manik\\ServerTCP\\Server\\src\\SavedFiles";
            this.fh = new AcceptFiles(
                    new BufferedInputStream(client.getInputStream()),
                    new BufferedOutputStream(new FileOutputStream(location +"/d2.txt")));
        }
        else if(arg.equals("2")){
            this.sf = new SearchInFile(client.getOutputStream(),client.getInputStream());
        }
    }
    /**
     * This method accepts a file sent by the client.java class
     * The method reads the whole content of the file and saves it to a certain directory
     */
    @Override
    public void run() {
        try {
            if(arg.equals("1")){
                this.fh.AcceptFileFromClient(fh);
            }
            else if(arg.equals("2")){
                this.sf.SearchStringInFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
