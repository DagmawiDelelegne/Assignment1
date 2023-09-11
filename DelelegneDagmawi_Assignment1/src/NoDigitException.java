package Assignment_1;
// thrown when there is no digit in the password
public class NoDigitException extends Exception {
	public NoDigitException() {
		this("The password must contain at least one digit");
	}
	public NoDigitException(String custom) {
		super(custom);
	}
}
