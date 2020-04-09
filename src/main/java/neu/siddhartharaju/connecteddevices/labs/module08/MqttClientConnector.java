/***
 * author Siddhartha
 */
package neu.siddhartharaju.connecteddevices.labs.module08;

import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/***
 * 
 * @author Siddhartha
 * Class Declaration
 */
public class MqttClientConnector implements MqttCallback,Runnable{
	MqttClient client;
	MqttConnectOptions mco;
	String protocol;
	String host;
	String port;
	String topic;
	SensorData sd;
	MQTTPublisher mpb;
	boolean Tls;
	String filePath;
	int qos;
	
	/***
	 * Logger variable for logging
	 */
	private Logger logger = Logger.getLogger(MqttClientConnector.class.getName());
	/***
	 * Class constructor
	 * @throws MqttException
	 */
	public MqttClientConnector() throws IOException, MqttException {
		super();
		this.host = "industrial.api.ubidots.com";
		this.port = "1883";
		this.topic = "/v1.6/devices/assignment_8/tempactuator/lv";
		this.protocol ="tcp";
		this.qos = 0;
		this.mco = new MqttConnectOptions();
		this.mco.setUserName("BBFF-xAJZhmZ4nMe1AqQlISPlNp21kTving");
		this.mco.setPassword("".toCharArray());
		this.mco.setKeepAliveInterval(60000);
		this.mpb = new MQTTPublisher();
		}
	/*
	 * Constructor
	 */
	public MqttClientConnector(String host,String token,String FilePath) throws Exception
	 {
		this.protocol ="ssl";
		this.qos = 0;
		this.mco = new MqttConnectOptions();
		this.host = host;
		this.mco.setUserName(token);
		this.port="8883";
		this.topic = "/v1.6/devices/assignment_8/tempactuator/lv";
		this.qos = 0;
		this.mco.setPassword("".toCharArray());
		this.mco.setKeepAliveInterval(60000);
		this.mpb = new MQTTPublisher();
		this.Tls = true;
		this.filePath = FilePath;
		MqttClient client = new MqttClient("ssl://yourbroker:8883", MqttClient.generateClientId(), new MemoryPersistence());
		SSLContext sslContext = SSLContext.getInstance("SSL");
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		KeyStore keyStore = readKeyStore();
		trustManagerFactory.init(keyStore);
		sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
		this.mco.setSocketFactory(sslContext.getSocketFactory());
		
	 }
	/*
	 * Method used to read the properties from the certificate file
	 */
	public KeyStore readKeyStore() throws Exception
	{
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream fis = new FileInputStream(this.filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		CertificateFactory cf  = CertificateFactory.getInstance("x.509");
		ks.load(null);
		while(bis.available()>0)
		{
			Certificate cert =  cf.generateCertificate(bis);
			ks.setCertificateEntry("jy_store"+bis.available(), cert);
		}
		return ks;
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
			logger.info("Connecting to :"+ClientAddress);
			this.client = new MqttClient(ClientAddress,	MqttClient.generateClientId());			
			this.client.setCallback(this);
			client.connect(this.mco);
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
		logger.info("Subscribing to -> " + this.topic);
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
		this.mpb.publishMessage(message.toString());
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
	 */
	public void run()
	{
		//"/iot-gateway/ubidots_cert.pem"
		logger.info("Connecting to Client");
		ClientConnection();
		logger.info("Connected to Ubidots MQTT");
		try {
			Thread.sleep(2000);
			this.client.subscribe(getSubscribeTopic(),this.qos);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}