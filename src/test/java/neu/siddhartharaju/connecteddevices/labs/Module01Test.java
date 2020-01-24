/**
 * 
 */
package neu.siddhartharaju.connecteddevices.labs;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.siddhartharaju.connecteddevices.labs.module01.SystemCpuUtilTask;
import neu.siddhartharaju.connecteddevices.labs.module01.SystemMemUtilTask;
import neu.siddhartharaju.connecteddevices.labs.module01.SystemPerformanceAdaptor;


/**
 * Test class for all requisite Module01 functionality.
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


public class Module01Test
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
	 * Cpu utilization test. Valid range 0 to 100
	 */
	@Test
	public void cpuUtilTest()
	{	
		assertTrue(SystemCpuUtilTask.getCpuUtil()>=(float)0);
	}

	/**
	 * 
	 * Memory utilization test. Valid range 0 to 100
	 */
	@Test
	public void memoryUtilTest()
	{	
		assertTrue(SystemMemUtilTask.GetHeapMemoryUtil()>=(float)0);
	}
	
	
	/**
	 * 
	 * Method testing for SystemPerformanceAdapter getRun() test. Valid range 0 to 100
	 */
	@Test
	public void getPerformanceMethodTest()
	{	
		assertTrue(SystemPerformanceAdaptor.getPerformance());
	}
	
}
