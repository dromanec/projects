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

		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("javaTutorial");
		

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

		Date first = new Date();
		Date second = new Date();

		try{
			first = format.parse("2014-10-01T00:00:00Z");
			//System.out.println(first.toString());
		}
		catch(ParseException e){
			System.out.println("first date is wrong");
		}

		try{
			second = format.parse("2014-01-16T00:00:00Z");
		}
		catch(ParseException e){
			System.out.println("second date is wrong");
		}
		
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