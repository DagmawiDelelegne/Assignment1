package Assignment_1;

public class LengthException extends Exception {
	public LengthException() {
		this("The password must be at least 6 characters long");
	}
	public LengthException(String custom) {
		super(custom);
	}
}
