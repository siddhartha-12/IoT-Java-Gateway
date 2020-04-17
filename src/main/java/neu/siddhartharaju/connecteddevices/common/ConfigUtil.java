package neu.siddhartharaju.connecteddevices.common;
import java.io.File;
import java.io.IOException;
import org.ini4j.Wini;
public class ConfigUtil {
	
	private Wini propFile = null;
	
	private String defaultPath = "config\\ConnectedDevicesConfig.props";
	//Constructor loading with null
	public ConfigUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		loadConfig(null);
	}
	//Fetching value based on key
	public String getValue(String section, String propKey)
	{
		String prop = propFile.get(section, propKey);
		return prop;
	}
	
	//Fetching Int value based on key
	public int getInt(String section, String propKey)
	{
		int prop =  Integer.parseInt(propFile.get(section, propKey)) ;
		return prop;
	}
	//Fetching boolean value based on key
	public boolean getBoolean(String section, String propKey)
	{
		boolean prop = Boolean.parseBoolean(propFile.get(section, propKey));
		return prop;
	}
	
	//Checking for a configuration
	public boolean hasConfig() 
	{
		String prop = propFile.get("smtp.cloud","host");
		if (prop.compareTo("Not Set") == 1)
				{
					return false;
				}
		return true;
	}
	
	//Loading config. If error occurs default config is loaded
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
			propFile = new Wini(new File(defaultPath));
			//System.out.println(e.toString());
			return false;
		}
	}
	

}
