/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.labs.module06.MqttClientConnector;

/**
 * Test class for all requisite Module06 functionality.
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
public class Module06Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	MqttClientConnector mcc;
	@Before
	public void setUp() throws Exception
	{
		mcc = new MqttClientConnector();
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
	public void MqttSetTopic()
	{
		assertTrue(this.mcc.setSubscribeTopic("Test", 1));
	}
	@Test
	public void MqttgetTopic()
	{
		assertNotNull(this.mcc.getSubscribeTopic());
	}
	@Test
	public void MqttClientConnection()
	{
		assertNotNull(this.mcc.ClientConnection());
	}
	
}
