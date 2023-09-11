package Assignment_1;

public class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		this("This password is weak");
	}
	public WeakPasswordException(String custom) {
		super(custom);
	}
}
