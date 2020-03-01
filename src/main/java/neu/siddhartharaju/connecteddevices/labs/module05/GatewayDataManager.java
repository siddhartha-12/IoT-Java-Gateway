package neu.siddhartharaju.connecteddevices.labs.module05;
import java.util.logging.Logger;

import neu.siddhartharaju.connecteddevices.common.ActuatorData;
import neu.siddhartharaju.connecteddevices.common.DataUtil;
import neu.siddhartharaju.connecteddevices.labs.module05.PersistenceUtil;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.common.SensorDataListener;

public class GatewayDataManager {
	
	static Logger logger = Logger.getLogger(GatewayDataManager.class.getName());
	
	public static void run()
	{
		SensorDataListener sdl = new SensorDataListener();
		
		PersistenceUtil pu = new PersistenceUtil();
		logger.info("Starting app\n Registering listener");
		pu.registerSensorDataDbmsListener(sdl);
	}
	
	public static boolean DataCheck(SensorData act)
	{
		//System.out.println(act.toString());
		ActuatorData adt = new ActuatorData();
		adt.setName("SenseHat Actuator");
		adt.setCurrent(act.getCurrent());
		adt.setTimestamp(act.getTimestamp());
		if(adt.getCurrent()>15)
		{
			adt.setCommand("Raise Temp");	
		}
		else if(act.getCurrent()<15)
		{
			adt.setCommand("Decrease Temp");
		}
		adt.setReading_number(act.getReading_number());
		adt.setMax_Value(act.getMax_Value());
		adt.setMin_value(act.getMin_value());
		adt.setTotal_value(act.getTotal_value());
		adt.setAvgTemp(adt.getAvgTemp());
		
		//System.out.println(adt.toString());
		PersistenceUtil pu = new PersistenceUtil();
		pu.WriteActuatorDataToDBMS(adt);
		return true;
	}
	
	public static void test()
	{
		ActuatorData adt = new ActuatorData();
		adt.addValue(11);
		PersistenceUtil pu = new PersistenceUtil();
		pu.WriteActuatorDataToDBMS(adt);
	}
	
	
	
	

}
