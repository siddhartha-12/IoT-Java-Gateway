package neu.siddhartharaju.connecteddevices.labs.module02;
import neu.siddhartharaju.connecteddevices.labs.module02.TempEmulatorAdaptor;

public class DeviceHandlerApp extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Creating thread
		Thread t1 = new Thread() {
			public void run()
			{
				//System.out.println("Starting Thread");
				TempEmulatorAdaptor.run();
			}
		};
		//Setting daemon thread property true
		t1.setDaemon(true);
		t1.start();
		while(true){}
				
	}

}
