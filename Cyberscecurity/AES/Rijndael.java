import java.io.FileInputStream;
import java.util.Scanner;


public class Rijndael {
	
	//This array encompasses the state of the 16-bit word that it's being encrypted.
	String[] state = new String[4];
	//This array represents the look-up table for the substitution process.
	String[] sbox = new String[16];
	
	String key;
	String expandedKey[] = new String[3];//Holds the three expanded round keys.
	String input = "";//Holds the input of the program.
	String inputProcessed = "";//Holds the program's input without white spaces and non-alphabetic characters.
	String output = "";//Holds the hex-numbers representing the plaintext's encrypted characters.
	
	/*
	 * This constructor initializes the values of the substitution table.
	 */
	public Rijndael(){
		sbox[0] = "1001";
		sbox[1] = "0100";
		sbox[2] = "1010";
		sbox[3] = "1011";
		sbox[4] = "1101";
		sbox[5] = "0001";
		sbox[6] = "1000";
		sbox[7] = "0101";
		sbox[8] = "0110";
		sbox[9] = "0010";
		sbox[10] = "0000";
		sbox[11] = "0011";
		sbox[12] = "1100";
		sbox[13] = "1110";
		sbox[14] = "1111";
		sbox[15] = "0111";
	}
	
	
	/*
	 * This method takes a string representing the 16-bit key.
	 */
	public void setKey(String key){
		this.key = key;
	}
	
	/*
	 * This method is responsible for checking if the binary key is a valid binary number.
	 */
	public boolean validBinaryKey(String wordKey){
		for(int i = 0; i<wordKey.length(); i++){
			//Check if every character of the key is 1 or 0.
			if(wordKey.charAt(i) != '0' && wordKey.charAt(i) != '1' ){
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * This method takes two bytes of characters in order to transform
	 * them in a 16-bit word that represents the encryption key.
	 */
	public String transformCharsToKeyBinary(byte char1, byte char2){
		int characterInteger1 = (int) (char1 & 0xFF);//Transform the signed value to unsigned value
		int characterInteger2 = (int) (char2 & 0xFF);
		
		String binary1 = "";
		String binary2 = "";
		String result = "";
		
		//The method used to transform from an integer to a binary string does not take into
		//account the 0 bit positions preceding the value. For example, it transforms 2 to 
		//"10", so the loop adds the necessary zeros to make it a representation of a byte.
		for(int i = 0; i < 8 - ((Integer.toBinaryString(characterInteger1)).length()); i++){
			binary1 = binary1 + "0";
		}
		
		binary1 = binary1 + Integer.toBinaryString(characterInteger1);
		
		for(int i = 0; i < 8 - ((Integer.toBinaryString(characterInteger2)).length()); i++){
			binary2 = binary2 + "0";
		}
		
		binary2 = binary2 + Integer.toBinaryString(characterInteger2);
		
		//Adds the bytes to make a 16-bit word.
		result = result + binary1 + binary2;
		
		return result;	
	}
	
	
	/*
	 *Converts a byte to String that represents the binary value of the byte 
	 */
	public String convertByteToBinary(byte characterByte){
		int characterInteger = (int) (characterByte & 0xFF);
		
		//Add one position since the command will return a 7-bit number
		String binary = "0"+Integer.toBinaryString(characterInteger);
		return binary;
	}
	
	
	/*
	 * This method takes a string that represents an binary value and
	 * converts it to an integer
	 */
	public int convertBinaryStringToInteger(String binary){
		return Integer.parseInt(binary,2);
	}
	
	/*
	 * This method is responsible for returning a string representing a 16-bit 
	 * binary number encompassing the current state of the block encryption.
	 */
	public String stateToWord(){
		String word = "";
		word = word + this.state[0] + this.state[1] + this.state[2] + this.state[3];
		return word;
	}
	
	/*
	 * This method takes a string representing two 8-bit binary numbers in order to 
	 * initialize or change the value of the object's array that represent the
	 * encryption state.
	 */
	public void changeState(String word1, String word2){
		this.state[0] = word1.substring(0,4);//Row 0 Column 0
		this.state[1] = word1.substring(4,8);//Row 1 Column 0
		this.state[2] = word2.substring(0,4);//Row 0 Column 1
		this.state[3] = word2.substring(4,8);//Row 1 Column 1
	}
	
	/*
	 * This method represents the g function used for expanding the key. It takes
	 * a 8-bit word (part of the key) and returns the value of the function.
	 */
	public String functionG(String wordKey, int roundExpansion){
		
		String result= "";
		String temp1, temp2;
		String word[] = new String[2];
		
		word[0] = wordKey.substring(0,4);
		word[1] = wordKey.substring(4,8);
		
		//Rotation of the word
		temp1 = word[0];
		temp2 = word[1];
		
		//Sub the word
		temp1 = subNibble(temp1);
		temp2 = subNibble(temp2);
		
		//Storing the rotation and substitution in the right side of the word.
		word[0] = temp2;
		word[1] = temp1;
		
		//Sets the nibbles in the word that would be returned as result.
		result = result + word[0] + word[1];
		
		//Last step of the function where the word is added to a constant depending on the round.
		if(roundExpansion == 1){
			result = addWord(result,"10000000");
		}
		else if(roundExpansion == 2){
			result = addWord(result,"00110000");
		}
		
		
		return result;
		
 	}
	
	/*
	 * This methods uses the global variable key in order to expand it
	 * and get the other round keys.
	 */
	public void expandKey(){
		String word0, word1, word2, word3, word4, word5;
		
		//Divide the original keys into two words.
		word0 = (this.key).substring(0,8);
		word1 = (this.key).substring(8,16);
		
		//Keys for the first round.
		word2 = addWord(functionG(word1,1),word0);
		word3 = addWord(word2,word1);
		
		//Keys for the second round.
		word4 = addWord(functionG(word3,2),word2);
		word5 = addWord(word4,word3);
		
		//Combining the six key-words into three keys.
		this.expandedKey[0] = "" + word0 + word1;
		this.expandedKey[1] = "" + word2 + word3;
		this.expandedKey[2] = "" + word4 + word5;
	}
	
	
	/*
	 * This methods takes takes two strings representing binary words and XOR them togethe.
	 * This method handles any word-size but works under the assumption that both
	 * words have equal lengths.
	 */
	public String addWord(String word1, String word2){
		int bit1, bit2;
		int bitResult;
		String result="";
		
		//Loop that traverses through each bit (character of the strings).
		for(int i = 0; i<word1.length(); i++){
			bit1 = Integer.parseInt(String.valueOf(word1.charAt(i)));
			bit2 = Integer.parseInt(String.valueOf(word2.charAt(i)));
			bitResult = bit1 ^ bit2;//XOR operation.
			//Transform result into string and concatenates it into the result.
			result = result + String.valueOf(bitResult);
		}
		
		return result;
		
	}
	
	/*
	 * Method that shift the rows of the nibbles of the state.
	 */
	public void shiftRows(){
		String columnA = this.state[1];
		String columnB = this.state[3];
		this.state[1] = columnB;
		this.state[3] = columnA;
	}
	
	/*
	 * Method that takes a string representing a round key and adds it to
	 * the state. 
	 */
	public void addRoundKey(String roundKey){
		String result = addWord(stateToWord(), roundKey);
		changeState(result.substring(0, 8), result.substring(8,16));
	}
	
	
	/*
	 * Method that substitutes the nibbles by looking up in the sub table.
	 */
	public String subNibble(String nibble){
		String subValue = sbox[convertBinaryStringToInteger(nibble)];//Gets the integer value of the nibble.
		return subValue;
	}
	
	/*
	 * Method that substitutes every nibble of the state. Uses a helper method
	 * subNibble(String).
	 */
	public void substitution(){
		String sub0 = subNibble(this.state[0]);  
		String sub1 = subNibble(this.state[1]); 
		String sub2 = subNibble(this.state[2]); 
		String sub3 =subNibble(this.state[3]); 
		this.state[0] = sub0;
		this.state[1] = sub1;
		this.state[2] = sub2;
		this.state[3] = sub3;
	}
	
	
	/*
	 * Method that mixes the columns of the nibbles of the state.
	 */
	public void mixColumns(){
		String nibble0 = ""; 
		String nibble1 = ""; 
		String nibble2 = "";
		String nibble3 = "";
		int bit0, bit1, bit2, bit3;
		
		//First new nibble
		bit0 = Integer.parseInt(String.valueOf(state[0].charAt(0))) ^ 
				Integer.parseInt(String.valueOf(state[1].charAt(2)));
		
		bit1 = Integer.parseInt(String.valueOf(state[0].charAt(1))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(3)));
		
		bit2 = Integer.parseInt(String.valueOf(state[0].charAt(2))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(1)));
		
		bit3 = Integer.parseInt(String.valueOf(state[0].charAt(3))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(1)));
		
		nibble0 = nibble0 + String.valueOf(bit0) + String.valueOf(bit1) + 
					String.valueOf(bit2) + String.valueOf(bit3);
		
		//Second new nibble
		bit0 = Integer.parseInt(String.valueOf(state[0].charAt(2))) ^ 
				Integer.parseInt(String.valueOf(state[1].charAt(0)));
		
		bit1 = Integer.parseInt(String.valueOf(state[0].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[0].charAt(3))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(1)));
		
		bit2 = Integer.parseInt(String.valueOf(state[0].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[0].charAt(1))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(2)));
		
		bit3 = Integer.parseInt(String.valueOf(state[0].charAt(1))) ^
				Integer.parseInt(String.valueOf(state[1].charAt(3)));
		
		nibble1 = nibble1 + String.valueOf(bit0) + String.valueOf(bit1) + 
				String.valueOf(bit2) + String.valueOf(bit3);
		
		//Third new nibble
		bit0 = Integer.parseInt(String.valueOf(state[2].charAt(0))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(2)));
		
		bit1 = Integer.parseInt(String.valueOf(state[2].charAt(1))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[3].charAt(3)));
		
		bit2 = Integer.parseInt(String.valueOf(state[2].charAt(2))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(0))) ^
				Integer.parseInt(String.valueOf(state[3].charAt(1)));
		
		bit3 = Integer.parseInt(String.valueOf(state[2].charAt(3))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(1)));
		
		nibble2 = nibble2 + String.valueOf(bit0) + String.valueOf(bit1) + 
				String.valueOf(bit2) + String.valueOf(bit3);
		
		//Fourth new Nibble
		bit0 = Integer.parseInt(String.valueOf(state[2].charAt(2))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(0)));
		
		bit1 = Integer.parseInt(String.valueOf(state[2].charAt(0))) ^ 
				Integer.parseInt(String.valueOf(state[2].charAt(3))) ^
				Integer.parseInt(String.valueOf(state[3].charAt(1)));
		
		bit2 = Integer.parseInt(String.valueOf(state[2].charAt(0))) ^ 
				Integer.parseInt(String.valueOf(state[2].charAt(1))) ^
				Integer.parseInt(String.valueOf(state[3].charAt(2)));
		
		bit3 = Integer.parseInt(String.valueOf(state[2].charAt(1))) ^ 
				Integer.parseInt(String.valueOf(state[3].charAt(3)));	
		
		nibble3 = nibble3 + String.valueOf(bit0) + String.valueOf(bit1) + 
				String.valueOf(bit2) + String.valueOf(bit3);
		
		//Stores the new nibbles on the state
		this.state[0] = nibble0;
		this.state[1] = nibble1;
		this.state[2] = nibble2;
		this.state[3] = nibble3;
	}
	
	
	/*
	 * This method takes a block of the bytes representing two characters
	 * of the plain-text, and return a string representing the hex values
	 * of the of bytes representing the characters' encryption.
	 */
	public String encipherBlock(char letter1, char letter2){
		
		//Initialize state
		byte char1 = (byte) letter1;
		byte char2 = (byte) letter2;
		
		//This if statement deals with case where the text
		//has a odd number of letters, such that, the block
		//to be enciphered needs a padding of 00000000
		if(letter2 == '0'){
			changeState(convertByteToBinary(char1),"00000000");
		}
		else{
			changeState(convertByteToBinary(char1),convertByteToBinary(char2));
		}
		
		
		addRoundKey(expandedKey[0]);
		
		//First Round
		substitution();
		shiftRows();
		mixColumns();
		addRoundKey(expandedKey[1]);
		
		//Second Round
		substitution();
		shiftRows();
		addRoundKey(expandedKey[2]);
	
		String finalState = stateToWord();
		
		//Get the integer values of the encrypted bytes
		int cipher1 = convertBinaryStringToInteger(finalState.substring(0,8));
		int cipher2 = convertBinaryStringToInteger(finalState.substring(8,16));
		
		String cipherChar1="";
		String cipherChar2="";
		
		//Tranform the integers to a hex value
		if(Integer.toHexString(cipher1).length() == 2){
			cipherChar1= Integer.toHexString(cipher1);
		}
		//Gives a preceding 0 position when the integer value has all of the bit positions of the first byte
		//as 0.
		else if(Integer.toHexString(cipher1).length() == 1){
			cipherChar1= "0"+Integer.toHexString(cipher1);
		}
		
		if(Integer.toHexString(cipher2).length() == 2){
			cipherChar2= Integer.toHexString(cipher2);
		}
		else if(Integer.toHexString(cipher2).length() == 1){
			cipherChar2= "0"+Integer.toHexString(cipher2);
		}
		
		//Adds the results to a string with the indication that they are hex values.
		String cipherText = "0x" + cipherChar1 +" " +"0x"+cipherChar2+" ";
			
		return cipherText;
		
	}
	
	
	/*
	 * Method that gets the original input and also processes it by erasing all
	 * of the white spaces and non-alphabetic characters.
	 */
	public void gatherInput(String token){
		input = input + token + "\n";//Stores input
		for(int i= 0; i < token.length(); i++){
			//Defines if the character is alphabetic
			if(token.charAt(i) >= 'A' && token.charAt(i) <= 'Z' || token.charAt(i) >= 'a' && token.charAt(i) <= 'z'){
				inputProcessed = inputProcessed + token.charAt(i);
			}
		}
	}
	
	/*
	 * This method encrypts all of the characters from input by using
	 * the S AES technique
	 */
	public void encipher(){
		int totalPairs = inputProcessed.length() / 2;
		expandKey();
		
		for(int i=1; i<totalPairs; i++){
			output = output + encipherBlock(inputProcessed.charAt(i*2-2),inputProcessed.charAt(i*2-1));
			if(i % 5 == 0){
				output = output + "\n";
			}
		}
		
		//Deal with odd-letter text case
		if(inputProcessed.length() % 2 != 0){
			output = output + encipherBlock(inputProcessed.charAt(inputProcessed.length()-1),'0');
		}
		
		
	}
	
	//DEBUGGING TOOLS
	/*
	 * Method that prints the state.
	 */
	public void printState(){
		System.out.println(this.state[0]+" "+ this.state[2]);
		System.out.println(this.state[1]+" "+ this.state[3]);
	}
	
	/*
	 * Method that prints that array having the expanded key.
	 */
	public void printExpandedKey(){
		System.out.println(this.expandedKey[0]+" "+ this.expandedKey[1]+" "+ this.expandedKey[2]);
	}
	

	public static void main(String [] args)throws Exception{
	
		Rijndael cryptogram = new Rijndael();
		
		//Validation of the key type
		if( !(args[0].equals("s")) && !(args[0].equals("b"))){
			System.out.println("The letter indicating the type of key is incorrect.");
			System.out.println("Reinitialize the program with a valid option.");
			return;//Exit program
		}
		

		//Validation of key as string of two characters
		if(args[0].equals("s")){
			//Checks if the key is equal to two characters representing a 16-bit binary number
			if(args[1].length() == 2){
			cryptogram.setKey(cryptogram.transformCharsToKeyBinary((byte) args[1].charAt(0),
														(byte)args[1].charAt(1)));
			}
			else{
				System.out.println("The string of chars is not represantable by 16 bits");
				System.out.println("Enter a string of two characters.");
				return;//Exit program
			}
		}
		
		//Validation if key is a string representing a binary number.
		if(args[0].equals("b")){
			//Validation if the key has 16 bits.
			if(args[1].length() == 16){
				//Validation if key is a valid binary number.
				if(cryptogram.validBinaryKey(args[1])){
					cryptogram.setKey(args[1]);
				}
				else{
					System.out.println("The binary number is not valid");
					System.out.println("Insert a valid number. Only zeros and ones are allowed.");
					return;//Exit program
				}	
			}
			else{
				System.out.println("The string representing the bits of the key is not equal to 16.");
				System.out.println("Enter a string representing a 16-bit binary number");
				return;//Exit program
			}	
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
		
		while(sc.hasNextLine()){//Reading of each line of the input file
			cryptogram.gatherInput(sc.nextLine());
	     }
		
		
		/**********ENCRYPTION OF THE PLAINTEXT************/
		cryptogram.encipher();
		
		
		//Input and output is printed
		System.out.println("Encryption KEY:  "+cryptogram.key+"\n");
	    System.out.println("Input Message: \n");
	    System.out.println(cryptogram.input);
	    System.out.println("Output Message: \n");
	    System.out.println(cryptogram.output);	
	     
	}
	
}
