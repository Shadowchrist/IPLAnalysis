package csvutility;

@SuppressWarnings("serial")
public class CustomException extends Exception
{
	ExceptionType type=null;
		
	public enum ExceptionType
	{
		FILE_NOT_FOUND, INCORRECT_TYPE, INCORRECT_DELIMITER, INCORRECT_HEADER, PARSING_ERROR;
	}
	public CustomException(ExceptionType type, String message)
	{
		super(message);
		this.type=type;
	}
}

