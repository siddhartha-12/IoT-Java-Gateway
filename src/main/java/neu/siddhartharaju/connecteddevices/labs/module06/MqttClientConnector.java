/***
 * author Siddhartha
 */
package neu.siddhartharaju.connecteddevices.labs.module06;

import java.util.logging.Logger;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
import neu.siddhartharaju.connecteddevices.common.DataUtil;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/***
 * 
 * @author Siddhartha
 * Class Declaration
 */
public class MqttClientConnector implements MqttCallback{
	MqttClient client;
	String protocol;
	String host;
	String port;
	String topic;
	SensorData sd;
	int qos;
	/***
	 * Logger variable for logging
	 */
	private Logger logger = Logger.getLogger(MqttClientConnector.class.getName());
	
	/***
	 * Class constructor
	 */
	public MqttClientConnector() throws IOException {
		super();
		this.sd = new SensorData();
		ConfigUtil cu = new ConfigUtil();
		cu.loadConfig("config\\ConnectedDevicesConfig.props");
		this.host = cu.getValue("mqtt.cloud", "host");
		this.port = cu.getValue("mqtt.cloud", "port");
		this.topic = "Siddhartha/Connected-Device/Sensor_Data";
		this.protocol ="tcp";
	}
	
	/***
	 * Method for initializationa and make Mqtt Client connection with the broker.
	 * Setting callback to self as the CallBack class has been extended to this class
	 * @return true
	 */
	public boolean ClientConnection()
	{
		try {
			String ClientAddress = this.protocol+"://"+host+":"+this.port;
			this.client = new MqttClient(ClientAddress,	MqttClient.generateClientId(), //ClientId
					new MemoryPersistence());
			this.client.setCallback(this);
			client.connect();
			return true;
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} //Persistence
	}
	/***
	 * 
	 * @param Topic - Topic for the mqtt channel
	 * @param qos - quality of service code
	 * @return - true
	 * Setter for topic subscribe
	 */
	public boolean setSubscribeTopic(String Topic,int qos)

	{
		this.topic = Topic;
		this.qos = qos;
		return true;
	}
	/***
	 * Subscribe getter method
	 * @return
	 */
	public String getSubscribeTopic()

	{
		return this.topic;
	}
	/***
	 * Callback handler if the connection is lost
	 */
	public void connectionLost(Throwable cause) {

		logger.info("The connection has been lost due to -> " + cause.toString());
	}
	
	/***
	 * Callback function on when the message arrives
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.info("Message received -> " + message.toString());
		this.sd = DataUtil.toSensorDataFromJson(message.toString());
		logger.info("Sensor Data - > " + sd.toString());
		this.client.unsubscribe(this.topic);
	}
	
	/***
	 * Callback method to handle delivery tokens
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
	}
	
	/***
	 * Class execution methods
	 * @return true of successful execution
	 *  @throws MqttException
	 */
	public boolean run() throws MqttException
	{
		logger.info("Connecting to Client");
		ClientConnection();
		logger.info("Connected");
		this.client.subscribe(getSubscribeTopic(),this.qos);
		return true;
	}
}


