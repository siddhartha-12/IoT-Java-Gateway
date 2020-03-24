package neu.siddhartharaju.connecteddevices.labs.module08;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.Random;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
import neu.siddhartharaju.connecteddevices.labs.module06.MqttClientConnector;
import com.ubidots.*;

public class UbidotsClientConnector implements Runnable {

	MqttClientConnector mcc;
	ConfigUtil config;
	ApiClient apiClient;
	DataSource dataSource;
	Variable variable;
	String apiKey;
	private Logger logger = Logger.getLogger(UbidotsClientConnector.class.getName());

	public UbidotsClientConnector() throws IOException {
		super();
//		this.mcc = mcc;
//		this.config = new ConfigUtil();
//		this.config.loadConfig("config\\ConnectedDevicesConfig.props");
//		this.mcc.setHost(config.getValue("ubidots.cloud", "host"));
		this.apiClient = new ApiClient();
		this.apiKey= "BBFF-xAJZhmZ4nMe1AqQlISPlNp21kTving";
		this.apiClient.fromToken(this.apiKey);
		this.apiClient.setBaseUrl("https://things.ubidots.com/api/v1.6/");
	}
	
	public boolean ApiSaveValue(int value)
	{	
		try {
			DataSource[] dataSourceArr = this.apiClient.fromToken(apiKey).getDataSources();
			for (DataSource dataSource : dataSourceArr) {				
			}
			DataSource dataSource = dataSourceArr[0];
			Variable[] variablearr = dataSource.getVariables();
			for (Variable var : variablearr) {
				if(var.getName().compareTo("TempSensor")==0)
				{
					var.saveValue(value);
					logger.info("Value sent - > " + value);
				}
				
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		Random rand = new Random();
		while(i<5)
		{
			try {
				ApiSaveValue(rand.nextInt(50));
				i++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
