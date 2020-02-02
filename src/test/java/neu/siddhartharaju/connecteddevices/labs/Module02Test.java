/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;
import neu.siddhartharaju.connecteddevices.labs.module02.TempSensorEmulatorTask;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.labs.module02.SmtpClientConnector;
/**
 * Test class for all requisite Module02 functionality.
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
public class Module02Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	TempSensorEmulatorTask emu;
	SmtpClientConnector smtp; 
	@Before
	public void setUp() throws Exception
	{
		emu = new TempSensorEmulatorTask();
		smtp = new SmtpClientConnector();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	// test methods
	
	/**
	 * 
	 */

	@Test
	public void testSmtpData()
	{
		assertTrue(smtp.publishMessage("Test Mail Java","If you are receiving this mail then the java test case have run successfully"));
	}
	@Test
	public void testSensorEmulatorTask()
	{
		boolean val = emu.sendNotification();
		assertTrue(val);
	}
	@Test
	public void testSendNotification()
	{
		assertTrue(emu.sendNotification());
	}
	@Test
	public void testSensorEmulatorTaskUpperBound()
	{
		float val = emu.getSensorData();
		assertTrue(val<=30);
	}
	
	@Test
	public void testSensorEmulatorTaskLowerBound()
	{
		float val = emu.getSensorData();
		assertTrue(val>=0);

	}
	
	
}
