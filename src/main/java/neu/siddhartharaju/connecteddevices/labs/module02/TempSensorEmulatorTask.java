package neu.siddhartharaju.connecteddevices.labs.module02;
import java.util.logging.Logger;

import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.labs.module02.SmtpClientConnector;
public class TempSensorEmulatorTask {

	private float threshold=5f;
	SensorData sensor =  new SensorData();
	Logger logger = Logger.getLogger(TempSensorEmulatorTask.class.getName());
	
	public float getSensorData()
	{
		float sensorValue;
		sensorValue = sensor.getCurrentValue();
		logger.info("\nTemperature: \nTime: "+sensor.getTimeStamp()+"\ncurrent : "+String.valueOf(sensorValue) +"\nAverage :"+String.valueOf(sensor.getAverageValue())+"\nSamples :"+String.valueOf(sensor.getCount())+"\nMin: "+String.valueOf(sensor.getMinValue())+"\nMax :"+String.valueOf(sensor.getMaxValue())+"\n");
		return sensorValue;
	}
	
	public boolean sendNotification()
	{	float tempValue = getSensorData();
		try {
		if( Math.abs (tempValue -sensor.getAverageValue())>threshold)
		{
			logger.info("Current temp exceeds average beyond " + String.valueOf(threshold) + ". Triggering alert...");
			String data = "Temperature Exceeded Warning!\n\nTemperature: \nTime:" +sensor.getTimeStamp()+"\ncurrent : "+String.valueOf(tempValue) +"\nAverage :"+String.valueOf(sensor.getAverageValue())+"\nSamples :"+String.valueOf(sensor.getCount())+"\nMin: "+String.valueOf(sensor.getMinValue())+"\nMax :"+String.valueOf(sensor.getMaxValue())+"\n";
			//System.out.println(data);
			SmtpClientConnector mail = new SmtpClientConnector();
	        mail.publishMessage("Temperature Alert Jave", data);
	        logger.info("\nMail sent");
		}
		return true;
		}
		catch(Exception e)
		{
			logger.info("Error in sending mail");
			logger.info(e.toString());
			return false;
		}
        
		
	}
}
