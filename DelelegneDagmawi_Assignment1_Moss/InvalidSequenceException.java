package Assignment_1;

public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		this("The password cannot contain more than two of the same character in sequence.");
	}
	public InvalidSequenceException(String custom) {
		super(custom);
	}
}
