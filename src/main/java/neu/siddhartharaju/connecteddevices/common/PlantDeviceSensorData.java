package neu.siddhartharaju.connecteddevices.common;

public class PlantDeviceSensorData {
	private float temperature;
	private float humidity;
	private float ldr;
	private float soilMoisture;
	private float GatewayMemoryUtil;
	private float GateCpuUtil;
	private float ConstrainCpuUtil;
	private float ConstrainMemoryUtil;
	private String timeStamp;
	
	public PlantDeviceSensorData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlantDeviceSensorData(float temperature, float humidity, float ldr, float soilMoisure,
			float gatewayMemoryUtil, float gateCpuUtil, float constrainCpuUtil, String timeStamp) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.ldr = ldr;
		this.soilMoisture = soilMoisure;
		GatewayMemoryUtil = gatewayMemoryUtil;
		GateCpuUtil = gateCpuUtil;
		ConstrainCpuUtil = constrainCpuUtil;
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "PlantDeviceSensorData \ntemperature=" + temperature + "\nhumidity=" + humidity + "\nldr=" + ldr
				+ "\nsoilMoisure=" + soilMoisture + "\nGatewayMemoryUtil=" + GatewayMemoryUtil + "\nGateCpuUtil="
				+ GateCpuUtil + "\nConstrainCpuUtil=" + ConstrainCpuUtil + "\ntimeStamp=" + timeStamp;
	}

	public float getTemperature() {
		return this.temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getLdr() {
		return this.ldr;
	}

	public void setLdr(float ldr) {
		this.ldr = ldr;
	}

	public float getSoilMoisure() {
		return this.soilMoisture;
	}

	public void setSoilMoisure(float soilMoisure) {
		this.soilMoisture = soilMoisure;
	}

	public float getGatewayMemoryUtil() {
		return this.GatewayMemoryUtil;
	}

	public void setGatewayMemoryUtil(float gatewayMemoryUtil) {
		GatewayMemoryUtil = gatewayMemoryUtil;
	}

	public float getGateCpuUtil() {
		return GateCpuUtil;
	}

	public void setGateCpuUtil(float gateCpuUtil) {
		GateCpuUtil = gateCpuUtil;
	}

	public float getConstrainCpuUtil() {
		return ConstrainCpuUtil;
	}

	public void setConstrainCpuUtil(float constrainCpuUtil) {
		ConstrainCpuUtil = constrainCpuUtil;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getConstrainMemoryUtil() {
		return ConstrainMemoryUtil;
	}

	public void setConstrainMemoryUtil(float constrainMemoryUtil) {
		ConstrainMemoryUtil = constrainMemoryUtil;
	}
	
}
