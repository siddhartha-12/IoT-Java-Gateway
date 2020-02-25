/**
 * 
 */
package neu.siddhartharaju.connecteddevices.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.siddhartharaju.connecteddevices.common.DataUtil;
import neu.siddhartharaju.connecteddevices.common.ActuatorData;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.labs.module05.PersistenceUtil;
import com.google.gson.Gson;

/**
 * Test class for DataUtil functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app
 * 5) Include a screen shot of the report when you submit your assignment
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class DataUtilTest
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	ActuatorData adt =  new ActuatorData();
	SensorData sdt = new SensorData();

	
	@Before
	public void setUp() throws Exception
	{
		
		this.adt.addValue(15);
		this.sdt.addValue(16);
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
	public void testActuatorDataToJson()
	
	{
		Gson gson = new Gson();
		String json = gson.toJson(this.adt);
		String cDu = DataUtil.toJsonFromActuatorData(this.adt);
		assertEquals(cDu, json);
	}
	
	/**
	 * 
	 */
//	@Test
//	public void testDeviceDataToJson()
//	{
//		
//		
//	}
	
	/**
	 * 
	 */
	@Test
	public void testSensorDataToJson()
	{
		Gson gson = new Gson();
		String json = gson.toJson(this.sdt);
		String cDu = DataUtil.toJsonFromSensorData(this.sdt);
		assertEquals(cDu, json);
	}
	
	/**
	 * 
	 */
	@Test
	public void testJsonToActuatorData()
	{
		Gson gson = new Gson();
		String json = gson.toJson(this.adt);
		String cDu = DataUtil.toJsonFromActuatorData(this.adt);
		ActuatorData acdt = new ActuatorData();
		acdt = DataUtil.toActuatorDataFromJson(json);
		assertEquals(acdt.getName(), this.adt.getName());
		assertEquals(acdt.getTimestamp(), this.adt.getTimestamp());
		assertEquals(acdt.getCommand(), this.adt.getCommand());
		assertEquals(acdt.getReading_number(),this.adt.getReading_number());
		assertTrue(acdt.getCurrent()==this.adt.getCurrent());
		assertTrue(acdt.getMin_value()==this.adt.getMin_value());
	}
	
	/**
	 * 
	 */
//	@Test
//	public void testJsonToDeviceData()
//	{
//	}
	
	/**
	 * 
	 */
	@Test
	public void testJsonToSensorData()
	{
		Gson gson = new Gson();
		String json = gson.toJson(this.adt);
		String cDu = DataUtil.toJsonFromActuatorData(this.adt);
		SensorData acdt = new SensorData();
		acdt = DataUtil.toSensorDataFromJson(json);
		assertEquals(acdt.getName(), this.adt.getName());
		assertEquals(acdt.getTimestamp(), this.adt.getTimestamp());
		assertEquals(acdt.getReading_number(),this.adt.getReading_number());
		assertTrue(acdt.getCurrent()==this.adt.getCurrent());
		assertTrue(acdt.getMin_value()==this.adt.getMin_value());
	}
	
}
