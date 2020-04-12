package neu.siddhartharaju.connecteddevices.common;
import com.google.gson.Gson;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.common.ActuatorData;

public class DataUtil {

	public static String toJsonFromSensorData(SensorData sensorData)
	{
		Gson gson = new Gson();
		String json = gson.toJson(sensorData);
		return json;
	}
	
	public static String toJsonFromActuatorData(ActuatorData actuatorData)
	{
		Gson gson = new Gson();
		String json = gson.toJson(actuatorData);
		return json;
	}
	
	public static SensorData toSensorDataFromJson(String json)
	{
		System.out.println(json);
		Gson gson = new Gson();
		SensorData sensorData = gson.fromJson(json, SensorData.class);
		return sensorData;
	}
	
	public static ActuatorData toActuatorDataFromJson(String json)
	{
		Gson gson = new Gson();
		ActuatorData actuatorData = gson.fromJson(json, ActuatorData.class);
		return actuatorData;
	}
	
	public static PlantDeviceSensorData toPlantDeviceSenosorDataFromJson(String json)
	{
		Gson gson = new Gson();
		PlantDeviceSensorData pdsd = gson.fromJson(json, PlantDeviceSensorData.class);
		return pdsd;
	}
	
	
	
}
