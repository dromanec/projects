/* Author: David Roman
 *
 * This application counts the letter frecuency of the letters of
 * a message on a text file. It is used for cryptanalysis. For more
 * information of the application, check the User's Guide.
 */


import java.io.FileInputStream;
import java.util.*;


public class LetterFrecuency {

	HashMap<Character, Integer> frecuency = new HashMap<Character, Integer>(); 
	
	/*This method analyzes every character of a line of the message
	 *and relates its appearance to an specific letter's frequency
	 *in t*/
	public void analyzeToken(String token){
		System.out.println(token);//Print a line of the input
		for(int i= 0; i < token.length(); i++){
			if(frecuency.containsKey(token.charAt(i))){//Analyzes if the character is Alphabetic
				int value  = frecuency.get(token.charAt(i)) + 1;//Increments the occurrence
				frecuency.put(token.charAt(i), value);//Records the occurrence
			}
		}
		
	}
	
	
	//This method prints the histogram of the frequencies of the letters
	public void histogram(){
		
		for(int i = 0 ; i<26; i++){
			
			char letterNew = (char) ((char) 'A'+i);
			
			System.out.print(letterNew+" ");
			for(int j = 0; j < frecuency.get(letterNew); j++){
				System.out.print("X");//Every X represents an occurrence
			}
			System.out.print("\n");
		}
	}
	
	
	//This method prints the frequencies of the letters
	public void printFrecuency(){
		System.out.println("\nTable of Frequencies:");
		System.out.println(" ");
		
		//This loop is used so that every element of the HashMap is retrieved in alphabetic order
		for(int i = 0 ; i<26; i++){
			char letter = (char) ((char) 'A'+i);
			System.out.println(letter+" "+frecuency.get(letter));
			
		}
	}
	
	public static void main(String [] args)throws Exception{
		LetterFrecuency f1 = new LetterFrecuency();
		
		//Initialization of the HashMap by storing all the letters in the Alphabet
		for(int i = 0 ; i<26; i++){
			char letter = (char) ((char) 'A'+i);
			f1.frecuency.put(letter, 0);
		}
		
		//Validates the file name
		 try {
			 System.setIn(new FileInputStream(args[0]));
	     } catch (Exception e) {
	            System.out.println("The file of the input does not exist.");
	            System.out.println("Reinitialize your program with the correct file name."); 
	    	 	return;//Exit the program
	     }
	     
		
		 Scanner sc = new Scanner(System.in);
	     
	     
		 System.out.println("Input Message:\n");
	     	 
		 //Parses every line of the input
	     while(sc.hasNextLine()){
	    	f1.analyzeToken(sc.nextLine().toUpperCase());//Analyzes each line 
	     }
	     sc.close();
	     
	    f1.printFrecuency();//prints frequencies
	    System.out.println("");
	    System.out.println("Histogram of Frequencies\n");
	    f1.histogram();//prints histogram
	    
	    
	    
	
	}  
	
	
}
