/**
 * 
 */
package neu.siddhartharaju.connecteddevices.common;

import neu.siddhartharaju.connecteddevices.common.SensorData;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SensorData functionality.
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
public class SensorDataTest
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	SensorData sensor;
	
	@Before
	public void setUp() throws Exception
	{
		sensor = new SensorData();
		sensor.addValue(11);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	// test methods
	
//	@Test
//	public void testSomething()
//	{
////		fail("Not yet implemented");
//	}
	
	@Test
	public  void testgetCurrent ()
	{
		float val = sensor.getCurrentValue();
		assertTrue((0<=val) && (val<=30));
	}
	
	@Test
	public void testgetAvg()
	{
		float val = sensor.getAverageValue();
		assertTrue((0<=val) && (val<=30));
		
	}
	
	@Test
	public void testgetMin()
	{
		float val = sensor.getMinValue();
		assertTrue((0<=val) && (val<=30));
		
	}
	
	@Test
	public void testgetMax()
	{
		float val = sensor.getMaxValue();
		assertTrue((0<=val) && (val<=30));
		
	}
	
	@Test
	public void testgetCount()
	{
		float val = sensor.getCount();
		assertTrue((0<=val) && (val<=30));
		
	}
	
	
	
}
