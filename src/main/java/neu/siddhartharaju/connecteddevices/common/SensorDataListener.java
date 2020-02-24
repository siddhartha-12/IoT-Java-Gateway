package neu.siddhartharaju.connecteddevices.common;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.labs.module05.GatewayDataManager;

public class SensorDataListener {
	
	public void onSensorMessage(SensorData sensordata)
	{
		GatewayDataManager.DataCheck(sensordata);
	}

}
