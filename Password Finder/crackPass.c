/* Author: David Roman
 *
 * This application is used to crack passwords of a users' paswword file.
 * It takes a dictionary of words to guess the passwords associated
 * to a user account. It takes a password file and a dictionary of words.
 * For more information on the format of the files and the application's design
 * check the User's Guide.
 */



#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

/*
 * This struct represents the users and their information from the password file.
 */
typedef struct User {
  char* username;
  char* salt;
  char* hashValue;
  char* password;
  int trials;//Stores the number of trials it took to find the right password.
} user;


/*
 * This method is responsible for finding the first colon of the
 * user information in the password file. The first colon indicates the
 * starting position of the hash-value.
 */
int startPosition(char* entry){
	int counterPosition = 0;//Counts the positions in the string.
	while(*entry){
		if(*entry == ':'){//Checks if the current position is equal to 0.
			return counterPosition;//Return the position where the colon was found.
		}
		counterPosition++;
		entry++;
	}
	return -1;//Check if the method did not found the first colon.
}


int endPosition(char* entry){
	int counterColon = 0;//Counts how many colons have been found.
	int counterPosition = 0;//Counts the positions in the string.

	while(*entry){
		if(*entry == ':'){//Check if the current position has a colon.
			counterColon++;//Counts the colon occurrence.
		}
		if(counterColon == 2){//Check if the second colon has been found.
			return counterPosition;//Return the position where the second colon was found.
		}
		counterPosition++;
		entry++;
	}

	return -1;//Check if the method did not found the second colon
}



/*
 * This method acts as a substring method to get the hash value of the password.
 * It takes a pointer to the buffer and, the start and ending indexes where the 
 * relevant string (hash-value) is located.
 */
char* getHashValue(char* buf, int start, int end){
	int length = ((end-1) - start) + 1;//Compute the lenght of the string.
  	char* hashValue = (char*) malloc(sizeof(char)*length);//Stores the hash-value
  	char* temp = hashValue;
  	int counter = 0;


  	//This loop traverses the string and records the relevant characters
  	//that represent the hash-value.
  	while(counter < end){
    	if(counter > start){
      		*temp = *buf;
      		temp++;
    	}
    	buf++;
    	counter++;
  	}
  	*temp = '\0';
  	return hashValue;
}




/*
 * This method acts as a substring method to get the username of the account.
 * It takes a pointer to the buffer the index of the first colon.
 */
char* getUserName(char* buf, int start){
	char* userName = (char*) malloc(sizeof(char)*start);//Stores thes username.
	char* temp = userName;
	int counter = 0;

	//This loop traverses the string and records the relevant characters
  	//that represent the User name.
	while(counter < start){
		*temp = *buf;
		temp++;
		buf++;
		counter++;
	}
	*temp = '\0';
	return userName;
}

/*
 * This method acts as a substring method to get the salt of the password.
 * It takes a pointer to the buffer and, the start and ending indexes where the 
 * relevant string (hash-value) is located.
 */
char* getSalt(char* buf, int start){
	char* salt = (char*) malloc(sizeof(char)*3);//Stores the salt.
	char* temp = salt;
	int counter = 0;

	//This loop traverses the string and records the relevant characters
  	//that represent the salt.
	while(counter < start+3){
		if(counter > start){
			*temp = *buf;
			temp++;
		}
		buf++;
		counter++;
	}

	*temp = '\0';
	return salt;
}

int countUsers(char* fileName){
	FILE *ptr_file;
	char buf [1000];
	ptr_file = fopen(fileName, "r");
	int numberUsers = 0;

	while(fgets(buf,1000,ptr_file) != NULL){
		numberUsers++;
	}
	return numberUsers;
}


/*
 * This method is resposible of for creating the user structs using the information
 * of the password file.
 */
user** createUsers(char* fileName, int numberUsers){
	
	//The following allocation of memory serve as an array of the structs type user.s
	user** totalUsers = (user**) malloc((sizeof(user*)*numberUsers)+1);
	user** temp = totalUsers;//Pointer that traverses through the array of pointers of struct user
	FILE *ptr_file;
	char buf [1000];//Create buffer.
	ptr_file = fopen(fileName, "r");//Read the file

	//This variable is used to make sure the array totalUsers is not overflowed.
	//It is assumed that for every line on the user file, there is the infomation
	//of one user. However this variable is used to assure that the number of times
	//the loop will run is equivalent to the number of users defined in by the method
	//countUsers(char*).
	int counterUsersInput = 0;

	while(fgets(buf,1000,ptr_file) != NULL && counterUsersInput < numberUsers){
		user* currentUser = (user*)malloc(sizeof(user));

		buf[999] = '\0';//Place the null character at the end of buffer.
		int start = startPosition(buf);//Get the position of the first colon.
		int end = endPosition(buf);//Get the position of the second colon.

		char* hash = getHashValue(buf, start, end);//Get string of the hash-value.
		char* user = getUserName(buf,start);//Get the string of the user name.
		char* saltValue = getSalt(buf,start);//Get the string of the salt.

		//Enter information in a the struct of the current created user.s
		currentUser -> username = user;
		currentUser -> salt = saltValue;
		currentUser -> hashValue = hash;
		currentUser -> password = NULL;
		currentUser -> trials = 0;//This value is initialized to 0 tries.

		*temp = currentUser;//Store the current user in the array of user.
		temp++;
		counterUsersInput++;
	}
	
	
	fclose(ptr_file);

	return totalUsers;//Return the array of users.
}


/*
 * This method is responsible of counting the number of letters of the
 * string passed until hitting a new line character. This method is useful
 * for counting the letters fo each word of a dictionary.
 */
int countLetters(char* entry){
	int counterPosition = 0;
	while(*entry){
		if(*entry == '\n'){//Limiti for counting letters.s
			return counterPosition;
		}
		counterPosition++;
		entry++;
	}
	return -1;//Check if the method found the first colon
}


/*
 * This method is repojsible for checking each word's hash-value of a dictionary and find
 * a match of them with the hash value of the users. This method attempts to find the passwords
 * of the users.
 */
void  checkDictionary(char* fileName, user** totalUsers){
	
	user** temp;//Pointer that traverses through the array of pointers of struct user
	FILE *ptr_file;
	char buf [1000];
	int limit;//Defines the length of each word of the dictionary
	ptr_file = fopen(fileName, "r");
	int counter = 0;
	
	while(fgets(buf,100,ptr_file) != NULL){
		int limit = countLetters(buf);//Counts the letters of the word of the dictionary.
		buf[limit] = '\0';//Sets the limit of the buffer
		temp = totalUsers;

		//This loop traverses through all of the users of the array
		while(*temp != NULL){
			user* currentUser = *temp;

			//Checks if the hash-value of the dictionary's word matches the one of the user.
			if(strcmp(crypt(buf, currentUser -> salt), currentUser -> hashValue) == 0){
				char* passwordFinal = (char*) malloc(sizeof(char)*limit);//Define size of password.
				strcpy(passwordFinal,buf);//Copies the dictionary's letter in the user's password

				currentUser -> password = passwordFinal;
				currentUser -> trials = counter + 1;//Defines the number of tries need to get the password.
			}
			temp++;
		}
		counter++;
	}
	
	fclose(ptr_file);
}


/*
 * This method is reponsible for for printing the users's name, password and number of tries
 * for getting the password.
 */
void printUsers(user** arrayUsers){
	user* currentUser;
	while(*arrayUsers != NULL){
		user* currentUser = *arrayUsers;
		printf("user:%s ",currentUser -> username);
		if((currentUser -> password) == NULL){
			printf("password:NULL ");
		}
		else{
			printf("password:%s ",currentUser -> password);
		}

		if((currentUser -> password) != 0){
			printf("trials:%d\n",currentUser -> trials);
		}
		else{
			printf("trials:NOT FOUND\n");
		}
		arrayUsers++;
	}
}


/*
 * This method is reponsible for traversing the collection of users and freeing the memory
 * linked to them.
 */
void freeMemory(user** arrayUsers){
	user** temp = arrayUsers;
	user* currentUser;
	while(*temp != NULL){
		user* currentUser = *temp;
		free((currentUser -> username));
		free((currentUser -> salt));
		free((currentUser -> hashValue));
		if((currentUser -> password) != NULL){
			free((currentUser -> password));
		}
		temp++;
	}
	free(arrayUsers);
}

int main(int argc, char** argv){

	user** listUsers = createUsers(argv[1],countUsers(argv[1]));
	checkDictionary(argv[2],listUsers);
	printf("\nUSER'S INFORMATION.\n\n");
	printUsers(listUsers);
	freeMemory(listUsers);


}



