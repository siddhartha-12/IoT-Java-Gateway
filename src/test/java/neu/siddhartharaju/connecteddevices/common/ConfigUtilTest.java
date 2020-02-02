/**
 * 
 */

package neu.siddhartharaju.connecteddevices.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
/**
 * Test class for ConfigUtil functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app.
 * 5) Include a screen shot of the report when you submit your assignment.
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class ConfigUtilTest
{
	// static
	
	public static final String DIR_PREFIX = "./sample/";
	
	public static final String TEST_VALID_CFG_FILE   = DIR_PREFIX + "ConnectedDevicesConfig.props";
	
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	private static ConfigUtil configutil;
	
	@Before
	public void setUp() throws Exception
	{
		// make sure test files exist
//		assertTrue(_validTestFile.exists());
//		assertTrue(ConfigUtil.getInstance().loadConfig(TEST_VALID_CFG_FILE));
		configutil =  new ConfigUtil();
	}
	
	// test methods
	
	/**
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#getBooleanProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetBooleanProperty()
	{
//		String useWebAccessStr = "False"; // read the property from the appropriate section in the config file.
//		
		assertTrue(configutil.getBoolean("ubidots.cloud", "useWebAccess"));
		
		
	}
	
	/**
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#getIntegerProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetIntegerProperty()
	{
		assertEquals(465, configutil.getInt("smtp.cloud", "port"));
	}
	
	/**
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#loadConfig(java.lang.String)}.
	 */
	@Test
	public void testGetProperty()
	{
		assertEquals("Not equal", "smtp.gmail.com",(configutil.getValue("smtp.cloud", "host")));
	}
	
	/**
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#hasProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testHasProperty()
	{
		assertNotNull(configutil.getValue("smtp.cloud", "host"));
	}
	
	/**
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#hasSection(java.lang.String)}.
	 */
	@Test
	public void testHasSection()
	{
		assertTrue(configutil.hasConfig());
	}
	
	/**
	 * @throws IOException 
	 * Test method for {@link neu.siddhartharaju.connecteddevices.common.ConfigUtil#isConfigDataLoaded()}.
	 * @throws  
	 */
	@Test
	public void testIsConfigDataLoaded()
	{

	}
	
}
