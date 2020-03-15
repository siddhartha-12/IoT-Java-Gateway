/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;

import static org.junit.Assert.assertTrue;

import org.eclipse.californium.core.CoapServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.labs.module07.CoapServerConnector;
import neu.siddhartharaju.connecteddevices.labs.module07.TempResourceHandler;

/**
 * Test class for all requisite Module07 functionality.
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
public class Module07Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		
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
	public void testServerResourceAdd()
	{
		CoapServerConnector scs = new CoapServerConnector();
		TempResourceHandler trh = new TempResourceHandler("Temp");
		scs.set_coapServer();
		assertTrue(scs.addResource(trh));
	}
	
	@Test
	public void testServerStartStop()
	{
		CoapServerConnector scs = new CoapServerConnector();
		TempResourceHandler trh = new TempResourceHandler("Temp");
		scs.start();
		assertTrue(scs.stop());	
	}
	
	@Test
	public void testSetServer()
	{
		CoapServerConnector scs = new CoapServerConnector();
		assertTrue(scs.set_coapServer());
	}
	
	
	
}
