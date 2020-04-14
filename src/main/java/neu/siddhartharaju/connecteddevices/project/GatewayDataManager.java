package neu.siddhartharaju.connecteddevices.project;
import java.util.logging.Logger;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
public class GatewayDataManager {
	MQTTConstraintConnector mcc;
	MqttUbidotConnector muc;
	Logger logger;
	ConfigUtil cu;
	//Constructor
	public GatewayDataManager() throws Exception{
		super();
		// TODO Auto-generated constructor stub
		logger = Logger.getLogger(GatewayDataManager.class.getName());
		this.cu = new ConfigUtil();
		this.cu.loadConfig("config\\ConnectedDevicesConfig.props");
		this.mcc = new MQTTConstraintConnector();
		this.muc = new MqttUbidotConnector(this.cu.getValue("MQTTubidots.cloud", "host"),this.cu.getValue("MQTTubidots.cloud", "apiKey"),this.cu.getValue("MQTTubidots.cloud", "certFile"));		
	}
	//Method for application initialization
	public void run()
	{
		logger.info("Starting Gateway Application");
		Thread t1 = new Thread(this.mcc);
		Thread t2 = new Thread(this.muc);
		t1.start();
		t2.start();
	}
	
	

}
