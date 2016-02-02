package hello;

import org.joda.time.LocalTime;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.lang.Exception;

import static java.util.Arrays.asList;



public class HelloWorld {
    public static void main(String[] args) {

    	/*Set up a connection with a MongoDB active client and connects to a database*/
		MongoClient mongoClient = new MongoClient();//Set up connection
		MongoDatabase db = mongoClient.getDatabase("javaTutorial");//Defining database
		

		//Define the format for creating dates
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

		//Variable holders of the created dates
		Date first = new Date();
		Date second = new Date();

		/*Try blocks for variable holders*/
		try{
			first = format.parse("2014-10-01T00:00:00Z");//Creation of Date one
		}
		catch(ParseException e){
			System.out.println("first date is wrong");//Error message
		}

		try{
			second = format.parse("2014-01-16T00:00:00Z");//Creation of date two
		}
		catch(ParseException e){
			System.out.println("second date is wrong");//Error message
		}
		

		/*Adding a document to the database*/
		db.getCollection("restaurants").insertOne(
        new Document("address",
                new Document()
                        .append("street", "2 Avenue")
                        .append("zipcode", "10075")
                        .append("building", "1480")
                        .append("coord", asList(-73.9557413, 40.7720266)))
                .append("borough", "Manhattan")
                .append("cuisine", "Italian")
                .append("grades", asList(
                        new Document()
                                .append("date", first)
                                .append("grade", "B")
                                .append("score", 11),
                        new Document()
                                .append("date", second)
                                .append("grade", "B")
                                .append("score", 17)))
                .append("name", "Vella")
                .append("restaurant_id", "41704620"));
		
	}
}