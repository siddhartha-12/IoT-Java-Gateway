package neu.siddhartharaju.connecteddevices.project;
import java.io.IOException;
import java.util.logging.Logger;

import org.joda.time.DateTime;

import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
import neu.siddhartharaju.connecteddevices.common.PlantDeviceSensorData;
import neu.siddhartharaju.connecteddevices.labs.module06.MqttClientConnector;
import com.ubidots.*;

public class UbidotsClientConnector implements Runnable {

	MqttClientConnector mcc;
	ConfigUtil config;
	ApiClient apiClient;
	DataSource dataSource;
	Variable variable;
	String apiKey;
	SmtpClientConnector scc;
	private Logger logger = Logger.getLogger(UbidotsClientConnector.class.getName());
	/*
	 * Class constructor
	 */
	public UbidotsClientConnector() throws IOException {
		super();
		this.config = new ConfigUtil();
		this.config.loadConfig("config\\ConnectedDevicesConfig.props");
		this.apiClient = new ApiClient();
		this.apiKey= config.getValue("ubidots.cloud","apiKey");
		this.apiClient.fromToken(this.apiKey);
		this.apiClient.setBaseUrl(config.getValue("ubidots.cloud","baseUrl"));
		this.scc =  new SmtpClientConnector();
	}
	
	/*
	 * Method to send value to ubidots
	 */
	public boolean ApiSaveValue(PlantDeviceSensorData pdsd)
	{	pdsd.setTimeStamp(DateTime.now().toString());
		String data = "Hi\nFollowing is the updated device update\n"+pdsd.toString();
		scc.publishMessage("Device Data update", data);
		try {
			DataSource[] dataSourceArr = this.apiClient.fromToken(apiKey).getDataSources();
			DataSource dataSource = dataSourceArr[0];
			Variable[] variablearr = dataSource.getVariables();
			for (Variable var : variablearr) {
				//logger.info(var.getName());
				if(var.getName().compareTo("ConstrainMemoryUtil")==0)
				{
					var.saveValue(pdsd.getConstrainMemoryUtil());
				}
				else if(var.getName().compareTo("ConstrainCPUUtil")==0)
				{
					var.saveValue(pdsd.getConstrainCpuUtil());
				}
				else if(var.getName().compareTo("GatewayCpuUtil")==0)
				{
					var.saveValue(pdsd.getGateCpuUtil());
				}	
				else if(var.getName().compareTo("GatewayMemoryUtil")==0)
				{
					var.saveValue(pdsd.getGatewayMemoryUtil());
				}	
				else if(var.getName().compareTo("Humidity")==0)
				{
					var.saveValue(pdsd.getHumidity());
				}	
				else if(var.getName().compareTo("LDR")==0)
				{
					var.saveValue(pdsd.getLdr());
				}	
				else if(var.getName().compareTo("moisture")==0)
				{
					var.saveValue(pdsd.getSoilMoisure());
				}
				else if(var.getName().compareTo("Temperature")==0)
				{
					var.saveValue(pdsd.getTemperature());
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
		
	}

}
