package neu.siddhartharaju.connecteddevices.labs.module02;
import java.util.logging.Logger;

import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.labs.module02.SmtpClientConnector;
public class TempSensorEmulatorTask {
	//Setting threshold value to 5
	private float threshold=5f;
	SensorData sensor =  new SensorData();
	Logger logger = Logger.getLogger(TempSensorEmulatorTask.class.getName());
	//Fetching the sensor data and current parameters
	public float getSensorData()
	{
		float sensorValue;
		sensorValue = sensor.getCurrent();
		logger.info("\nTemperature: \nTime: "+sensor.getTimestamp()+"\ncurrent : "+String.valueOf(sensorValue) +"\nAverage :"+String.valueOf(sensor.getAvg())+"\nSamples :"+String.valueOf(sensor.getReading_number())+"\nMin: "+String.valueOf(sensor.getMin_value())+"\nMax :"+String.valueOf(sensor.getMax_Value())+"\n");
		return sensorValue;
	}
	//Testing if the threshold is reached. If reached sending a mail
	public boolean sendNotification()
	{	float tempValue = getSensorData();
		try {
		if( Math.abs (tempValue -sensor.getAvg())>threshold)
		{
			logger.info("Current temp exceeds average beyond " + String.valueOf(threshold) + ". Triggering alert...");
			String data = "Temperature Exceeded Warning!\n\nTemperature: \nTime:" +sensor.getTimestamp()+"\ncurrent : "+String.valueOf(tempValue) +"\nAverage :"+String.valueOf(sensor.getAvg())+"\nSamples :"+String.valueOf(sensor.getReading_number())+"\nMin: "+String.valueOf(sensor.getMin_value())+"\nMax :"+String.valueOf(sensor.getMax_Value())+"\n";
			//System.out.println(data);
			SmtpClientConnector mail = new SmtpClientConnector();
	        mail.publishMessage("Temperature Alert Java", data);
	        logger.info("\nMail sent");
		}
		return true;
		}
		catch(Exception e)
		{
			//In case of exception in sending mail returning false
			logger.info("Error in sending mail");
			logger.info(e.toString());
			return false;
		}
        
		
	}
}
