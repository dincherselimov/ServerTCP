package JunitTests.TestAcceptFiles;


import Config.Config;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class testAcceptFilesNegative {

    @Test
    public void testPathFile() throws IOException {
        /**
         * @param
         * @filePath String with path to file
         */
        Config config = new Config();
        String filepath = "D:\\Manik\\ServerTCP\\Server\\src\\SavedFiles\\d112312.txt";

        Path path = Paths.get(filepath);
        //Method to test if file exists
        boolean exists = Files.exists(path);
        //Method to check if file does not exist
        boolean notExists = Files.notExists(path);
        //Method to check if file is directory
        boolean isDir = Files.isDirectory(path);

        if (isDir) {
            System.out.println("File is a Directory");
        }
        else if (exists) {
            System.out.println("File exists!!");
        }
        else if (notExists) {
            System.out.println("File doesn't exist!!");
        }
        else {
            System.out.println("Program doesn't have access to the file!!");
        }
        assertTrue(exists);

        //Compares the two names
        //assertEquals("D:\\Java\\ServerTCP\\Server\\src\\SavedFiles\\testfile.txt", filepath);
    }
}
