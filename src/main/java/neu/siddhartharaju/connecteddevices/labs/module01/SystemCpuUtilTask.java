package neu.siddhartharaju.connecteddevices.labs.module01;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.*;

@SuppressWarnings("restriction")
public class SystemCpuUtilTask {
	
	public static float getCpuUtil()
	{
		

		OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	    double cpuload = bean.getSystemCpuLoad () * 100d;
	    return ((float)(cpuload));
		
	}

}
