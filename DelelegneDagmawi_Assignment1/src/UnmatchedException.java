package Assignment_1;
/**
	 * This exception occurs when passwords don't match
	 */
public class UnmatchedException extends Exception {
	public UnmatchedException() {
		this("Passwords do not match");
	}
	
	public UnmatchedException(String custom) {
		super(custom);
	}
}
