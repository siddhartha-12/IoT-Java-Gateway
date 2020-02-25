/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.siddhartharaju.connecteddevices.common.ActuatorData;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.labs.module05.PersistenceUtil;

/**
 * Test class for all requisite Module05 functionality.
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
public class Module05Test
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	PersistenceUtil pu;
	SensorData sdt;
	ActuatorData adt;
	@Before
	public void setUp() throws Exception
	{
		sdt = new SensorData();
		adt = new ActuatorData();
		sdt.addValue(15);
		adt.addValue(11);
		this.pu = new PersistenceUtil();
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
	public void writeActuatorDataToDB()
	{
		pu.WriteActuatorDataToDBMS(this.adt);
		
//		fail("Not yet implemented");
	}
	
}
