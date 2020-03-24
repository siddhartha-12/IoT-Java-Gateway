/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.labs.module08.MQTTPublisher;
import neu.siddhartharaju.connecteddevices.labs.module08.MqttClientConnector;
import neu.siddhartharaju.connecteddevices.labs.module08.UbidotsClientConnector;

/**
 * Test class for all requisite Module08 functionality.
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
public class Module08Test
{
	MqttClientConnector mcc;
	MQTTPublisher mp;
	UbidotsClientConnector ucc;
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		this.mcc = new MqttClientConnector();
		this.mp = new MQTTPublisher();
		this.ucc = new UbidotsClientConnector();
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
	public void MqttSetTopicSubscriber()
	{
		assertTrue(this.mcc.setSubscribeTopic("Test", 1));
	}
	@Test
	public void MqttGetTopicSubscriber()
	{
		this.mcc.setSubscribeTopic("Test", 1);
		assertTrue(this.mcc.getSubscribeTopic()=="Test");
	}
	@Test
	public void MqttPublisher()
	{
		assertTrue(this.mp.publishMessage("Test Publish"));
	}
	@Test
	public void MqttPublisherGetterSetter()
	{
		assertTrue(this.mp.setTopic("Test"));
		assertTrue(this.mp.getTopic()=="Test");
		assertTrue(this.mp.setQos(1));
		assertTrue(this.mp.getQos()==1);
		assertTrue(this.mp.setBroker("Test.broker"));
		assertTrue(this.mp.getBroker()=="Test.broker");	
	}
	@Test
	public void TestUbidotsMessage()
	{
		assertTrue(this.mp.publishMessage("Test Publish"));
	}
}
