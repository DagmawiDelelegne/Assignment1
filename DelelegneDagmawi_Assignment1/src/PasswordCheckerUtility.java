package Assignment_1;

import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
	
	
	
	// Compares the passwords but does not return anything
public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
	if(!password.equals(passwordConfirm)){
		throw new UnmatchedException(); 
	}
}



	// compares the passwords and if they match returns true and if not false
public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
	return password.equals(passwordConfirm);
}

	//checks if the length of the password fits the requirement 
public static boolean isValidLength(String password) throws LengthException{
	  if (password.length() >= 6) {
	        return true; // Password meets the minimum length requirement
	    } else {
	        throw new LengthException();
	    }
}


	//checks if the password has an upper character 
public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
	String [] characters = password.split("");
	for(String c : characters) {
		int asciiValue = (int) c.charAt(0); // Get the ASCII value of the character

        if (asciiValue >= 65 && asciiValue <= 90) {
            return true; // Found an upper case letter, so return true
        }
	}
	 throw new NoUpperAlphaException();
}



	//checks if the password has a lower case character
public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
	String [] characters = password.split("");
	for(String c : characters) {
		int asciiValue = (int) c.charAt(0); // Get the ASCII value of the character

        if (asciiValue >= 97 && asciiValue <= 122) {
            return true; // Found an upper case letter, so return true
        }
	}
	 throw new NoLowerAlphaException();
}
public static boolean hasSpecialChar (String password) throws NoSpecialCharacterException{
if (Pattern.compile("[\\!\\@\\#\\[\\]\\`\\~\\,\\{\\}\\:\\;\\.\\$\\%\\^\\&\\*\\(\\)\\-\\_\\+\\=\\<\\>\\?]").matcher(password).find()) {
    return true;
}
else throw new NoSpecialCharacterException();
}


	// checks if there is a character occurring simultaneously more than 2 times
	// if it does InvalidSequenceException is thrown
public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
	
	char [] chars = password.toCharArray();
	for(int i = 0; i < chars.length - 2; i++) {
		if(chars[i]==chars[i+1] && chars[i+1]==chars[i+2]) {
			throw new InvalidSequenceException();
		}
	}
	return true;
	
}

public static boolean hasDigit(String password) throws NoDigitException{
	if(!password.matches(".*\\d.*")){
		throw new NoDigitException();
	}
	else return true;
}

public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
	// each method works as defined above
	if(!isValidLength(password)) {
		throw new LengthException();
	}
	if(!hasDigit(password)) {
		throw new NoDigitException();
	}
	if(!NoSameCharInSequence(password)) {
		throw new InvalidSequenceException();
	}
	
	if(!hasUpperAlpha(password)) {
		throw new NoUpperAlphaException();
	}
	
	if(!hasLowerAlpha(password)) {
		throw new NoLowerAlphaException();
	}
	
	if(!hasSpecialChar(password)) {
		throw new NoSpecialCharacterException();
	}
	
	
	return true;
}


public static boolean hasBetweenSixAndNineChars(String password) {
	if(password.length() >= 6 && password.length() <= 9) {
		return true;
	}
	else return false;
}

// checks if the password is weak
// i didn't check for the length being less or equal to 6 because it is 
// already done inside isValidPassword
public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	if(isValidPassword(password) && password.length() <= 9 ) {
		throw new WeakPasswordException();
	}
	else return false;
}


public static ArrayList<String> getInvalidPasswords(ArrayList<String>passwords) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
	ArrayList<String> invalidPasswords = new ArrayList<String>();
	for(int i = 0; i < passwords.size(); i++) {
		String password = passwords.get(i);
		try {
			isValidPassword(password); // This will throw an exception if the password is invalid
		}
		catch(Exception e){
			String temp =  password + " " + e.getMessage();
			invalidPasswords.add(temp);
		}
	}
	return invalidPasswords;
}


}
