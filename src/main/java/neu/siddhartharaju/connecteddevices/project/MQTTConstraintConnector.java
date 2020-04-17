/***
 * author Siddhartha
 */
package neu.siddhartharaju.connecteddevices.project;

import java.util.logging.Logger;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
import neu.siddhartharaju.connecteddevices.common.DataUtil;
import neu.siddhartharaju.connecteddevices.common.PlantDeviceSensorData;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.joda.time.DateTime;
/***
 * 
 * @author Siddhartha
 * Class Declaration
 */
public class MQTTConstraintConnector implements MqttCallback,Runnable{
	MqttClient client;
	String protocol;
	String host;
	String port;
	String topic;
	PlantDeviceSensorData pdsd;
	UbidotsClientConnector ucc;
	int qos;
	/***
	 * Logger variable for logging
	 */
	private Logger logger = Logger.getLogger(MQTTConstraintConnector.class.getName());
	
	/***
	 * Class constructor
	 */
	public MQTTConstraintConnector() throws IOException {
		super();
		this.pdsd = new PlantDeviceSensorData();
		ConfigUtil cu = new ConfigUtil();
		cu.loadConfig("config\\ConnectedDevicesConfig.props");
		this.host = cu.getValue("mqtt.cloud", "host");
		this.port = cu.getValue("mqtt.cloud", "port");
		this.topic = "project/constraint/sensor";
		this.protocol ="tcp";
		this.ucc =  new UbidotsClientConnector();
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
		this.pdsd = DataUtil.toPlantDeviceSenosorDataFromJson((message.toString()));
		this.pdsd = GatewayDataAdaptor.getGatewaySystemPerformance(this.pdsd);
		this.pdsd.setTimeStamp(DateTime.now().toString());
		logger.info("Plant Data received from constraint device - > " + pdsd.toString());
		//this.client.unsubscribe(this.topic);
		ucc.ApiSaveValue(this.pdsd);
		logger.info("Value sent to cloud\n\n\n\n\n");
	}
	
	/***
	 * Callback method to handle delivery tokens
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
	}
	/***
	 * Method for publishing received data to broker
	 */
	public boolean publishMessage(String topic,String val)
	{
		try {
			ClientConnection();
			this.client.connect();
			logger.info("Connecte to constraint device");
			MqttMessage message = new MqttMessage(val.getBytes());
			message.setQos(this.qos);
			this.client.publish(topic, message);
			logger.info("Message published to contrain device");
			this.client.disconnect();
			logger.info("client to constrained disconnected");
		} catch (MqttSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/***
	 * Class execution methods
	 * @return true of successful execution
	 *  @throws MqttException
	 */
	public boolean runSubscriber() throws MqttException
	{
		logger.info("Connecting to Constraint subcriber");
		ClientConnection();
		logger.info("Subscriber to MQTT topic:" + getSubscribeTopic());
		this.client.subscribe(getSubscribeTopic(),this.qos);
		return true;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			runSubscriber();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


