package neu.siddhartharaju.connecteddevices.labs.module08;

public class GatewayHandlerApp extends Thread{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	/***
	 * The following is the application initializer method.
	 * It creates an instance of 2 threads, 1 for initiating Ubidots and another for MqttClient for publishing
	 */
		Thread t1 = new Thread(new UbidotsClientConnector());
		Thread t2 = new Thread(new MqttClientConnector("industrial.ubidots.com","BBFF-xAJZhmZ4nMe1AqQlISPlNp21kTving","G:\\Sid\\Northeastern\\Courses\\Connected Devices\\Workspaces\\iot-gateway\\src\\main\\java\\neu\\siddhartharaju\\connecteddevices\\labs\\module08\\ubidots_cert.pem"));
		t1.start();
		t2.start();						
	}
}
