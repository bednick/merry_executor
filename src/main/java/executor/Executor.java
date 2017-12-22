package executor;

import java.io.IOException;
import java.util.List;

public class Executor implements IExecutor
{
	@Override public void exec(List<String> commands) throws FailProcessingException
	{
		try
		{
			for (String command : commands)
			{
				
				Process pr = start(command);
				while (pr.isAlive())
				{
					try
					{
						pr.waitFor();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				int exit = pr.exitValue();
				if (exit != 0)
				{
					throw new FailProcessingException();
				}
				
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private Process start(String command) throws IOException
	{
		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
		return processBuilder.start();
	}
}