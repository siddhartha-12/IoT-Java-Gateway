package neu.siddhartharaju.connecteddevices.labs.module02;
import java.util.logging.Logger;

import neu.siddhartharaju.connecteddevices.labs.module02.TempSensorEmulatorTask;
public class TempEmulatorAdaptor {

	static private Logger logger = Logger.getLogger(TempEmulatorAdaptor.class.getName());
	
	public static void run() 
	{
		logger.info("Starting Applicaton");
		TempSensorEmulatorTask emu = new TempSensorEmulatorTask();
		for(int i=0;i<5;i++)
		{
			emu.sendNotification();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
	}
}
