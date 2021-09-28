package ServerSideMethods;

import java.io.*;
import java.net.Socket;
import Config.Config;

/**
 * This class handles multiple client connection using Threads(which implements class Runnable)
 */
public class ClientHandler extends Thread {

    private AcceptFiles fh;
    private SearchInFile sf;
    private final Socket client;
    private String arg;
    BufferedReader inputStream;
    String[] args;
    //private final SearchString searchString;

    public ClientHandler(Socket socket) throws IOException {

        this.client = socket;
        inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String s = inputStream.readLine();
        System.out.println(s);
        while ((s == null)){
            s = inputStream.readLine();

        }
        args = s.split(";");

        if(args[0].equals("1")){
            //accept files from client and save them on this location + file_name
            String location = Config.getInstance().getAbsolute_path();
            String file_name = Config.getInstance().getFile_name();
            this.fh = new AcceptFiles(
                    new BufferedInputStream(client.getInputStream()),
                    new BufferedOutputStream(new FileOutputStream(location + args[1] )));
        }
        else if(args[0].equals("2")){
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
            if(args[0].equals("1")){
                this.fh.AcceptFileFromClient(fh);
            }
            else if(args[0].equals("2")){
                this.sf.SearchStringInFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
