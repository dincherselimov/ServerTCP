package JunitTests.TestAcceptFiles;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class TestAcceptFilesBorder {

@Test
    public void testPathFile() throws IOException {

        File filepath = new File("D:\\Manik\\ServerTCP\\Server\\src\\SavedFiles\\d1.txt");

        boolean empty = !(filepath.length() == 0);

        Path path = Paths.get(String.valueOf(filepath));
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

        System.out.println("There is a file with that name but the content is empty!!");
        //Compares the two names
        assertTrue(empty);

    }




}
