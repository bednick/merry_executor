package executor;

public class FailProcessingException extends Exception
{
	public FailProcessingException()
	{
		super();
	}
	
	public FailProcessingException(String mes)
	{
		super(mes);
	}
}
