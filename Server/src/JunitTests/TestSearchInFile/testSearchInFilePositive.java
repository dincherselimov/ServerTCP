package JunitTests.TestSearchInFile;

import ServerSideMethods.SearchInFile;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;


public class testSearchInFilePositive {


    private OutputStream OutputStream;
    private InputStream InputStream;
    private  Socket client;

    public testSearchInFilePositive( ) {

    }


    /**
     * 1 - testing if the file content is OK
     * 2 - testing if the directory to be saved is right
     * 3 - testing if the string is part of this file
     */
    @Test
    public void testSearchInFile() throws IOException {

        SearchInFile searchInFile = new SearchInFile(client.getOutputStream(),client.getInputStream());

         String s = searchInFile.searchStringInFile();

         String exp = "Testing";

         assertEquals(exp,s);

    }

}
