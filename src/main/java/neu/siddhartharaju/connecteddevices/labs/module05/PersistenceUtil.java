package neu.siddhartharaju.connecteddevices.labs.module05;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import neu.siddhartharaju.connecteddevices.common.ActuatorData;
import neu.siddhartharaju.connecteddevices.common.DataUtil;
import neu.siddhartharaju.connecteddevices.common.SensorData;
import neu.siddhartharaju.connecteddevices.common.SensorDataListener;
import neu.siddhartharaju.connecteddevices.labs.module02.TempSensorEmulatorTask;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
public class PersistenceUtil {

	private Logger logger = Logger.getLogger(PersistenceUtil.class.getName());
    private String host; //= "redis-11821.c114.us-east-1-4.ec2.cloud.redislabs.com"; // 127.0.0.1 | redis-11821.c114.us-east-1-4.ec2.cloud.redislabs.com
    private int port; //= 11821; // 6379 | 11821
    private String auth; //= "connected2020";
	
    public PersistenceUtil() {
		super();
		// TODO Auto-generated constructor stub
		this.host = "redis-11821.c114.us-east-1-4.ec2.cloud.redislabs.com";
	    this.port = 11821;
	    this.auth = "connected2020";
		    
	}
	
	
	public boolean registerSensorDataDbmsListener(SensorDataListener sdl)
	{   int i=0;
		final Jedis jedis = new Jedis(this.host,this.port);
		jedis.connect();
		jedis.auth(this.auth);
		SensorDataListener fsdl = sdl;
		//logger.info("In Listener");
		SubscribeClass sc = new SubscribeClass()
		{
			@Override
	        public void onMessage(String channel, String message) {
	           
	            logger.info("Listening");
	            if(channel.equals("Sensor")) {
	                /* Unsubscribe from channel C1 after first message is received. */ 
	                unsubscribe(channel);
	                //logger.info("REceived message key" + message);
	                super.setkeyVal(message);
	            }
	        }
		};
		
		
		//Started polling by resubscribing to the channel
		while(i<5)
		{
			jedis.subscribe(sc, "Sensor");
			String jstring = jedis.get(sc.getkeyVal());
			SensorData sdt  = DataUtil.toSensorDataFromJson(jstring);
			sdl.onSensorMessage(sdt);
			logger.info("--------------------------------------------------------");
			logger.info("\nNew Sensor value received from Python \n\n" + sdt.toString());
			logger.info("--------------------------------------------------------");
			i++;
		}

		return true;
	}
	
//	public boolean registerActuatorDataDbmsListener(SensorDataListener sdl)
//	{
//		
//	}
	
//	public boolean WriteSensorDataDbmsListener(SensorData sensorData)
//	{
//		return true;
//	}
	
	
	public boolean WriteActuatorDataToDBMS(ActuatorData actuatorData)
	{
		Jedis jedis = new Jedis(this.host,this.port);
		jedis.connect();
		jedis.auth(this.auth);
        
        /* Publishing message to channel Actuator */
        jedis.publish("Actuator","Actuator"+ actuatorData.getTimestamp());
        String message =DataUtil.toJsonFromActuatorData(actuatorData);
        logger.info(message);
        jedis.publish("Actuator"+ actuatorData.getTimestamp(), message);
		jedis.set("Actuator"+ actuatorData.getTimestamp(),message);
		logger.info("Message sent to db");
		jedis.close();
		return true;
	}

}
