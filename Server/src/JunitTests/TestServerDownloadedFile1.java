package JunitTests;

import Config.Config;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

/**
 *This Junit test is testing if there is downloaded file from TCP Server using java.io.File package
 * @assertEquals  Checks the two paths
 */

class TestServerDownloadedFile1 {
    // Method to check if the file exists and is not a directory
    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    @Test

    /**
     * @param
     * @filePath String with path to file
     */

    public static void main(String[] args) throws IOException {
        //String for path
        Config config = new Config();
        String filepath = config.getAbsolute_path()+config.getFile_name();
        //Creates new File instance for the given path
        File file = new File(filepath);

        if (isFileExists(file)) {
            System.out.println("File exists!!");
        }
        else {
            System.out.println("File doesn't exist or program doesn't have access " +
                    "to the file");
        }
        //Compares the two paths
        assertEquals("D:\\Java\\ServerTCP\\Server\\src\\SavedFiles\\testfile.txt", filepath);
        System.out.println("Paths are equal!!");
    }
}
