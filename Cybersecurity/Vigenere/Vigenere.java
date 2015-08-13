/* Author: David Roman
 *
 * This application decrypts and encrypts messages using
 * Vigenere's method. For more information, check
 * the User's Guide.
 *
 */

import java.io.FileInputStream;
import java.util.Scanner;


public class Vigenere {
	String input;
	String output;
	String keyword;
	String type;
	int letterCounter;
	int blockNumber;
	
	
	public Vigenere(){
		this.letterCounter = 1;
		this.blockNumber = 0;
		this.input="";
		this.output="";
	}
	
	
	
	
	/*This method uses modular arithmetic to encrypt a letter as indicated in
	 * the Vigenere's Table.
	 */
	public char transformEncrypt(char key, char plain){
		char cipherChar = (char) ((((key-'A') + (plain-'A'))%26)+'A');
		return cipherChar;
	}
	
	
	
	
	
	/*This method uses modular arithmetic to decrypt a letter as indicated in
	 * the Vigenere's Table.
	 */
	public char transformDecrypt(char key, char cipher){
		char plainChar;
		if(cipher>=key){//Case when the cipher-letter is greater or equal than the key-letter
			plainChar = (char)((cipher-key) + 'A');//Find the alphabetic distance from cipher-letter to key-letter in the table,
												   // to add the same distance to starting point 'A'
		}
		
		else{//Case when the cipher-letter is less than the key-letter
			plainChar=(char)(('Z'- key)+(cipher-'A')+'A'+1);//Find the alphabetic distance from cipher-letter to key-letter
															//in the table, to add same distance to starting point 'A'.
		}
		return plainChar;
	}
	
	
	
	
	/*This methods enciphers a string using Vignere's strategy*/
	public void encipherToken(String token){
		input = input + token + '\n';//Stores input
		
		for(int i= 0; i < token.length(); i++){
			if(token.charAt(i) >= 'A' && token.charAt(i) <= 'Z' ){//Defines if the character is alphabetic
				
				if(letterCounter%5==0){//Defines the spacing between letters
					
					//The next line uses letter counter to see what letter of the keyword
					//corresponds to an specific character in the line. That's the reason
					//for analyzing the letterCounter modulo length of the keyword. Since, the counter
					//starts at 1, then it is necessary to subtract one from letterCounter.
					output = output + transformEncrypt(keyword.charAt( (letterCounter-1)%keyword.length() ) , token.charAt(i) )+ " ";
					
					letterCounter++;
					blockNumber++;
					if(blockNumber%10 == 0){//Defines when to put the new line character when 10 5-letter blocks have been formed
						output = output + '\n';
					}
				}
				
				else{//This option happens when a letter is within a block
					output = output + transformEncrypt(keyword.charAt( (letterCounter-1)%keyword.length() ) , token.charAt(i) );
					letterCounter++;
				}
			}
		}	
	}
	
	
	
	
	/*This methods deciphers a string using Vignere's strategy*/
	public void decipherToken(String token){
		
		input = input + token + '\n';//Stores input
		
		for(int i= 0; i < token.length(); i++){
			if(token.charAt(i) >= 'A' && token.charAt(i) <= 'Z' ){//Defines if the character is alphabetic
				
				if(letterCounter%5==0){//Defines the spacing between letters
					
					//The next line uses letter counter to see what letter of the keyword
					//corresponds to an specific character in the line. That's the reason
					//for analyzing the letterCounter modulo length of the keyword. Since, the counter
					//starts at 1, then it is necessary to subtract one from letterCounter.
					output = output + transformDecrypt(keyword.charAt( (letterCounter-1)%keyword.length() ) , token.charAt(i) )+ " ";
					
					letterCounter++;
					blockNumber++;
					if(blockNumber%10 == 0){//Defines when to put the new line character when 10 5-letter blocks have been formed
						output = output + '\n';
					}
				}
				
				else{//This option happens when a letter is within a block
					output = output + transformDecrypt(keyword.charAt( (letterCounter-1)%keyword.length() ) , token.charAt(i) );
					letterCounter++;
				}
			}
		}
		
	}
	
	
	
	
	public static void main(String [] args)throws Exception{
		Vigenere cryptogram = new Vigenere();
		
		cryptogram.keyword = args[0];
		//Validation of the key
		if(args[0].length() > 26){
			System.out.println("The key has to be less or equal to 26 Alphabetic letters.");
			System.out.println("Reinitialize the program with a valid key.");
			return;//Exit program
		}
		else{
			cryptogram.keyword = (args[0]).toUpperCase();
		}
				
		//Validation of the type of command 
		if(args[1].equalsIgnoreCase("encipher")){
			cryptogram.type = "encipher";
		}
		else if(args[1].equalsIgnoreCase("decipher")){
			cryptogram.type = "decipher";
		}
		else{
			System.out.println("The instruction for the program is not valid.");
			System.out.println("Enter 'encipher' or 'decipher' as your instructions.");
			System.out.println("Reinitialize the program with a valid instruction.");
			return;//Exit program
		}
		
		//Validation of the input file
		try {
			 System.setIn(new FileInputStream(args[2]));
	    } catch (Exception e) {
	    	System.out.println("The file of the input does not exist.");
	    	System.out.println("Reinitialize your program with the correct file name."); 
	    	return;//Exit the program
	    }
		
		Scanner sc = new Scanner(System.in);
		 
		while(sc.hasNextLine()){//Decryption /encryption of each line of the input file
			if((cryptogram.type).equalsIgnoreCase("encipher")){
				cryptogram.encipherToken(sc.nextLine().toUpperCase());
			}	
			else{
				cryptogram.decipherToken(sc.nextLine().toUpperCase());
			}
	     }
		
	     sc.close();
		
	     //Input and output is printed
	     System.out.println("Input Message: \n");
	     System.out.println(cryptogram.input);
	     System.out.println("Output Message: \n");
	     System.out.println(cryptogram.output);	
		
	}
	

}
