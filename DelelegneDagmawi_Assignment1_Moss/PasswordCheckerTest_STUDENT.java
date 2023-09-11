package Assignment_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Dagmawi Delelegne
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	
		String[] p = {
	            "GoodP@ssword1",
	            "n0upperalpha1@",
	            "NOLOWER1@",
	            "ValdBw2@",
	            "sssequencE@0",
	            "Nodigit$",
	            "Successful@2",
	            "ValidPass@3",
	            "CorrectPass@4",
	            "afdaW!3234"
	            
	        };
		
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		   passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
            assertTrue(PasswordCheckerUtility.isValidPassword("notShort@1"));
            PasswordCheckerUtility.isValidPassword("$H0rt");
            assertTrue("No exception thrown", false);
        } catch (LengthException e) {
            assertTrue("Threw LengthException", true);
        } catch (Exception e) {
            assertTrue("Invalid exception thrown", false);
        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(1));
			assertTrue("No exception thrown", false);
		}
		catch(NoUpperAlphaException e){
			assertTrue("Threw NoUpperAlphaException", true);
		}
		catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(2));
			assertTrue("No exception thrown", false);
		}
		catch(NoLowerAlphaException e){
			assertTrue("Threw NoLowerAlphaException", true);
		}
		catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			boolean w = PasswordCheckerUtility.isValidPassword(passwords.get(3));
			assertTrue(w);
		}
		catch(Exception e) {
			assertTrue("Threw Invalid exception", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(4));
			assertTrue("No exception thrown", false);
		}
		catch(InvalidSequenceException e){
			assertTrue("Threw InvalidSequenceException ", true);
		}
		catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(5));
			assertTrue("No exception thrown", false);
		}
		catch(NoDigitException e){
			assertTrue("Threw NoDigitException", true);
		}
		catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(6)));
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(7)));
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(8)));
			assertTrue("No exception thrown", true);
		}
		catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testInvalidPasswords() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		ArrayList<String> invalid = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		assertEquals(true, invalid.get(0).contains("n0upperalpha1"));
		assertEquals(true, invalid.get(1).contains("NOLOWER1@"));
		assertEquals(true, invalid.get(2).contains("sssequencE@0"));
		assertEquals(true, invalid.get(3).contains("Nodigit$"));

	}
	
}
