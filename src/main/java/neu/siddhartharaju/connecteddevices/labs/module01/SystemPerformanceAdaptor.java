package neu.siddhartharaju.connecteddevices.labs.module01;

import java.util.logging.Logger;

public class SystemPerformanceAdaptor {

	public static boolean getPerformance()
	{
		float cpuUtil = SystemCpuUtilTask.getCpuUtil();// Fetching CPU utilization
		float memUtil = SystemMemUtilTask.GetHeapMemoryUtil(); // Fetching Memory utilization
		
		Logger logger = Logger.getLogger(SystemPerformanceAdaptor.class.getName());
		logger.info("Starting performance app");
		logger.info("CPU Utilization : " + cpuUtil +"%"); //Logging CPU utilization
		logger.info("Memory Utilization : " + memUtil + "%"); // Logging Memory Utilizations
		
		return (true);
	}
}
