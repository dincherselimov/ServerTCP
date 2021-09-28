package ServerSideMethods;

import Config.Config;

import java.io.*;

/**
 * This class has a method for searching a string in file from the server-side
 */
public class SearchInFile {
    String ss;
    //getting info from the other socket(client)
    BufferedReader input;
    //sending info to the other socket(client)
    PrintWriter out;

    //Constructor with parameters
    public SearchInFile(OutputStream outputStream, InputStream inputStream){
        this.input = new BufferedReader(new InputStreamReader(inputStream));
        this.out = new PrintWriter(outputStream);

    }

    public void SearchStringInFile() throws IOException {
        // Search for a string in file on this location path + file_name
        String location = Config.getInstance().getAbsolute_path();

        //Creation of File Descriptor for input file
        File f  = new File( location + "/d1.txt");

        //Creation of File Reader object
        FileReader fr = null;
        fr = new FileReader(f);

        //Creation of BufferedReader object
        BufferedReader br = new BufferedReader(fr);

        //Initialize the word Array
        String[] words = null;

        //reading the given String from the client and if the string is not read continue reading
        String s = null;
        s = input.readLine();

        while ((s == null)){
            try {
                s = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The given string is: " +  s);

        //Initialize the word to zero
        int count=0;

        //Reading Content from the file
        while(true)
        {
            try {
                if ((ss = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Split the word using space
            words=ss.split(" ");
            for (String word : words)
            {
                //Search for the given word
                if (word.equals(s))
                {
                    //If Present increase the count by one
                    count++;
                }}}
        //Check for count not equal to zero
        if(count!=0) {
            out.println("The given word is present for " +count+ " Times in the file");
            out.flush();
        }
        else {
            out.println("The given word is not present in the file");
            out.flush();
        }
        fr.close();
    }
}
