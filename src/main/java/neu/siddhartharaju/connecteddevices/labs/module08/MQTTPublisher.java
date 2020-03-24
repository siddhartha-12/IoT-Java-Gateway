package neu.siddhartharaju.connecteddevices.labs.module08;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
public class MQTTPublisher {
	private Logger logger = Logger.getLogger(MQTTPublisher.class.getName()); 
	String topic;
	String content;
	int qos;
	String broker;
	String clientId;
	MemoryPersistence persistence;
	MqttClient client;
	public MQTTPublisher() throws MqttException {
		super();
		this.topic        = "actuatorData";
		this.qos          = 0;
		this.broker       = "tcp://mqtt.eclipse.org:1883";
		this.persistence  = new MemoryPersistence();
		this.clientId     = "Gateway";
		this.client	      = new MqttClient(this.broker, this.clientId, this.persistence);
	}

	public boolean publishMessage(String val)
	{
		try {
			this.client.connect();
			logger.info("Client connected for Gateway to constrained");
			MqttMessage message = new MqttMessage(val.getBytes());
			message.setQos(this.qos);
			this.client.publish("ActuatorData/change", message);
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

	public String getTopic() {
		return topic;
	}

	public boolean setTopic(String topic) {
		this.topic = topic;
		return true;
	}

	public int getQos() {
		return qos;
	}

	public boolean setQos(int qos) {
		this.qos = qos;
		return true;
	}

	public String getBroker() {
		return broker;
	}

	public boolean setBroker(String broker) {
		this.broker = broker;
		return true;
	}

	public String getClientId() {
		return clientId;
	}

	public boolean setClientId(String clientId) {
		this.clientId = clientId;
		return true;
	}
	
	



}
