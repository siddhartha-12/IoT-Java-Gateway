package neu.siddhartharaju.connecteddevices.labs.module06;

public class GatewayHandlerApp extends Thread{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	/***
	 * The following methos is the application initializer method.
	 * It creates an instance of MqttClientConnector and call run method
	 */
		MqttClientConnector mcc = new MqttClientConnector();
				mcc.setSubscribeTopic("Siddhartha/Connected-Device/Sensor_Data", 2);
				mcc.run();
				
	}

}
