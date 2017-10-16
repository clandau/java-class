package progProjChpt9;

public class DivisionByZeroException extends Exception{
	public DivisionByZeroException() {
		super("Division by zero exception!");
	}
	
	public DivisionByZeroException(String message) {
		super(message);
	}
}
