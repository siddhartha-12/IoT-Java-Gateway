package neu.siddhartharaju.connecteddevices.labs.module01;

import java.util.logging.Logger;

public class SystemPerformanceAdaptor {

	public static boolean getPerformance()
	{
		float cpuUtil = SystemCpuUtilTask.getCpuUtil();
		float memUtil = SystemMemUtilTask.GetHeapMemoryUtil();
		
		Logger logger = Logger.getLogger(SystemPerformanceAdaptor.class.getName());
		logger.info("Starting performance app");
		logger.info("CPU Utilization : " + cpuUtil +"%");
		logger.info("Memory Utilization : " + memUtil + "%");
		
		return (true);
	}
}
