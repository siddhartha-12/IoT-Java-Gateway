package neu.siddhartharaju.connecteddevices.project;
import neu.siddhartharaju.connecteddevices.common.PlantDeviceSensorData;

public class GatewayDataAdaptor {
	public static PlantDeviceSensorData getGatewaySystemPerformance(PlantDeviceSensorData pdsd)
	{
		float cpuUtil = SystemCpuUtilTask.getCpuUtil();// Fetching CPU utilization
		float memUtil = SystemMemUtilTask.GetHeapMemoryUtil(); // Fetching Memory utilization
		pdsd.setGateCpuUtil(cpuUtil);
		pdsd.setGatewayMemoryUtil(memUtil);
		return (pdsd);
	}
	
}
