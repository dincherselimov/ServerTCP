package ServerSideMethods;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * This class accepts the file send by the Client Side method
 * and saves the file to a certain directory
 */
public class AcceptFiles {
    private BufferedInputStream bis = null;
    private BufferedOutputStream bos = null;

    /**
     * @param bufferedInputStream
     * @param bufferedOutputStream
     */
    public AcceptFiles(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        this.bis = bufferedInputStream;
        this.bos = bufferedOutputStream;
    }

    /**
     * Reading the content of file and writing it
     * @param fh
     * @throws IOException
     */
    public void acceptFileFromClient(AcceptFiles fh) throws IOException {

        //Create byte array
        byte[] b = new byte[1024 * 8];

        //Read character array
        int len = 0;
        while (true) {
            try {
                assert bis != null;
                if ((len = bis.read(b)) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert bos != null;
            //write the data from file
            try {
                bos.write(b, 0, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //close resource
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Upload succeeded");
    }
}
