package mongo;


import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * MongoDB class makes local connection to the mongodb database
 */
public class MongoDB {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static void main(String[] args) {
        //Start new MongoClient
        MongoClient mongoClient = new MongoClient();
        //get the existing database with name "name"
        DB database = mongoClient.getDB("ServerDB");
        database.getName();
        //get the existing collection with name "name"
        DBCollection ServerDBCollection = database.getCollection("ServerDBCollection");

        /**
         * Read the content of xml file
         * Parse xml to json
         * Parse json to JSONObject
         * Add the parsed xml to the mongodb database
         */
        try {
            //Read the content of xml file(path to xml file)
            File file = new File("Server/src/mongo/node.xml");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int ptr = 0;
            StringBuilder builder = new StringBuilder();
            while ((ptr = br.read()) != -1) {
                builder.append((char) ptr);
            }
            String xml = builder.toString();

            //parse the xml to JSONObject
            JSONObject xmlJSONObj = XML.toJSONObject(xml);

            //Print the parsed xml in the console
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);

            //push the parsed xml into the mongodb database
            DBObject dbObject = (DBObject) JSON.parse(String.valueOf(xmlJSONObj));
            ServerDBCollection.insert(dbObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // read the first doc to make sure that we've inserted correctly
        DBObject firstDoc = ServerDBCollection.findOne();
        System.out.println(firstDoc);

        DBCursor cursor = ServerDBCollection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            System.out.println(obj);
        }
    }
}



