package neu.siddhartharaju.connecteddevices.common;

import java.io.File;
import java.io.IOException;

import org.ini4j.Wini;

public class ConfigUtil {
	
	private Wini propFile = null;
	
	public String getValue(String section, String propKey)
	{
		String prop = propFile.get(section, propKey);
		return prop;
	}
	
	public boolean hasConfig() 
	{
		String prop = propFile.get("smtp.cloud","host");
		if (prop.compareTo("Not Set") == 1)
				{
					return false;
				}
		return true;
	}
	
	public boolean loadConfig(String filename) throws IOException 
	{
		try 
		{
		propFile = new Wini(new File(filename));
		//System.out.println("File Loaded succefully");
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
	}
	

}
