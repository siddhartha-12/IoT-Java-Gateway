package neu.siddhartharaju.connecteddevices.labs.module01;

import java.lang.management.*;

public class SystemMemUtilTask {

	public static float GetHeapMemoryUtil()
	{
		double initMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax() ;
		double usedMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
		
		
		double memUtil = (usedMemory/initMemory)*100d; //Calculating heap memory utilization
		
		
		return ((float)memUtil);
	}
}
