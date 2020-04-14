package neu.siddhartharaju.connecteddevices.project;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.*;

@SuppressWarnings("restriction")
public class SystemCpuUtilTask {
	/***
	 * Method for getting CPU utilization
	 */
	public static float getCpuUtil()
	{
		OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	    double cpuload = bean.getSystemCpuLoad () * 100d; //Fetching CPU load and converting in percentage
	    return ((float)(cpuload));
	}
}
