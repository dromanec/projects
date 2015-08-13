/* Author: David Roman
 *
 * This application decrypts and encrypts messages using the
 * Mixed Alphabet Cipher method. For more information, check
 * the User's Guide
 *
 */



import java.io.FileInputStream;
import java.util.*;

public class MixedCipher{

	String input;//Variable that stores the input of the file
	String output;//Variable that stores the output of the program
	HashMap<Character, Character> textToCipher = new HashMap<Character, Character>();//Manages the mapping for text-to-ciphers 
	HashMap<Character, Character> cipherToText = new HashMap<Character, Character>();//Manages the mapping for cipher-to-text
	HashSet <Character> analyzed = new HashSet<Character>();//Helps the mapping for text-to-ciphers for detecting what characters 
															//were already considered
																
	String key;//Stores the keyword
	String type;//Stores the command that says whether the program will encipher or decipher
	int letterCounter;//Counts how many letters have been in stored in the output. It helps to signal when the 
					  //5 letter block starts and ends
	int blockNumber;//Counts how many blocks of 5 letter words have been stored in the output. It helps to signal when
					//a line has 10 words, such that another line is created in the output for the next 10 blocks
	
	public MixedCipher(){
		this.letterCounter = 1;
		this.blockNumber = 0;
		this.input="";
		this.output="";
	}
	
	//Method that places the keyword in the text-tocipher mapping
	public void keyPlacement(){
		for(int i = 0 ; i<key.length(); i++){//Loop that traverses the keyword
			char letter = (char) ((char) 'A'+i);//Text letter that will be associated with the cipher letter
			textToCipher.put(letter, key.charAt(i));//Association of the text letter and cipher letters
			analyzed.add(key.charAt(i));//Store what text letter was already associated
		}
	}
	
	public void generateTextToCipherTable(){
		keyPlacement();//Associates the characters of the keyword
		int parallelCounter = 0;//This counter helps to traverse through the cipher alphabet in order to made the association
		for(int i = key.length() ; i<26; i++){//The loop considers that some characters have been associated already
			char letterText = (char) ((char) 'A'+i);//Letter from the text alphabet that needs to be associated
			boolean nextTextLetter = false;
			while(nextTextLetter == false){//Checks if the association is successful
				char letterCipher = (char) ((char) 'A'+(parallelCounter));//Gets a potential cipher letter for the association
				if(analyzed.contains(letterCipher) == false){//Checks if the cipher letter was already associated
					textToCipher.put(letterText,letterCipher);//Association is done
					analyzed.add(letterCipher);//Informs that a particular cipher letter was already associated
					nextTextLetter = true;
				}
				parallelCounter++;
			}
		}	
	}
	
	public void generateCipherToTextTable(){
		generateTextToCipherTable();//Generates the text-to-cipher mapping
		for(int i = 0 ; i<26; i++){
			char letter = (char) ((char) 'A'+i);
			cipherToText.put(textToCipher.get(letter),letter);//Inversion of the relation
															  //This process generates the cipher-to-text mapping
		}
		
	}
	
	//This enciphers a string with the text-to-cipher mapping
	public void encipherToken(String token){
		input = input + token + '\n';//Stores input
		for(int i= 0; i < token.length(); i++){
			if(textToCipher.containsKey(token.charAt(i))){//Defines of the character is alphabetic
				if(letterCounter%5==0){//Defines the spacing between letters
					output = output +textToCipher.get(token.charAt(i)) + " ";
					letterCounter++;
					blockNumber++;
					if(blockNumber%10 == 0){//Defines when to put the new line character when 10 5-letter blocks have been formed
						output = output + '\n';
					}
				}
				else{//This option happens when a letter is within a block
					output = output +textToCipher.get(token.charAt(i));
					letterCounter++;
				}
			}
		}	
	}
	
	//This method deciphers a string with  the cipher-to-text mapping
	public void decipherToken(String token){
		input = input + token + '\n';//Stores input
		for(int i= 0; i < token.length(); i++){
			if(cipherToText.containsKey(token.charAt(i))){//Defines of the character is alphabetic
				if(letterCounter%5==0){//Defines the spacing between letters
					output = output +cipherToText.get(token.charAt(i)) + " ";
					letterCounter++;
					blockNumber++;
					if(blockNumber%10 == 0){//Defines when to put the new line character when 10 5-letter blocks have been formed
						output = output + '\n';
					}
				}
				else{//This option happens when a letter is within a block
					output = output +cipherToText.get(token.charAt(i));
					letterCounter++;
				}
			}
		}
	}
	
	
	public static void main(String [] args)throws Exception{
		
		MixedCipher cryptogram = new MixedCipher();
		
		//Initialization of the HashMap by storing all the letters in the Alphabet
		for(int i = 0 ; i<26; i++){
			char letter = (char) ((char) 'A'+i);
			cryptogram.textToCipher.put(letter, null);
		}
		
		//Validation of the key
		if(args[0].length() > 26){
			System.out.println("The key has to be less or equal to 26 Alphabetic letters.");
			System.out.println("Reinitialize the program with a valid key.");
			return;//Exit program
		}
		else{
			cryptogram.key = (args[0]).toUpperCase();
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
		
		cryptogram.generateCipherToTextTable();
		
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
