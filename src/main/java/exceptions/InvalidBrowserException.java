package exceptions;

public class InvalidBrowserException extends FrameworkException{
    
	public InvalidBrowserException(String message) {
		super("Invalid browser: " + message);
	}
}
