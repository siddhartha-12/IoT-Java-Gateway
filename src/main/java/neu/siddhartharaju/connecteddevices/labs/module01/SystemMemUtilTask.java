package neu.siddhartharaju.connecteddevices.labs.module01;

import java.lang.management.*;

public class SystemMemUtilTask {

	public static float GetHeapMemoryUtil()
	{
		double initMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax() ;
		double usedMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
		//System.out.println("Commited " + initMemory + "  || Used " + usedMemory);
		
		double memUtil = (usedMemory/initMemory)*100d; 
		//System.out.println(memUtil + "%");
		
		return ((float)memUtil);
	}
}
