package neu.siddhartharaju.connecteddevices.labs.module05;

import redis.clients.jedis.JedisPubSub;
import java.util.logging.Logger;
public class SubscribeClass extends JedisPubSub {

	
	private Logger logger = Logger.getLogger(SubscribeClass.class.getName());
	private String keyVal;
	
	

	public SubscribeClass() {
		super();
		// TODO Auto-generated constructor stub
		this.keyVal = "";
	}

	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
		super.onMessage(channel, message);
		
		logger.info("Listening");
        if(channel.equals("Sensor")) {
            /* Unsubscribe from channel C1 after first message is received. */ 
            unsubscribe(channel);
            logger.info("REceived message key" + message);
            this.setkeyVal(message);
        	}

		}

	public String getkeyVal() {
		return keyVal;
	}

	public void setkeyVal(String keyVal) {
		this.keyVal= keyVal;
	}
	
	
	
	
	}
