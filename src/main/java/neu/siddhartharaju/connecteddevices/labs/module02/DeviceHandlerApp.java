package neu.siddhartharaju.connecteddevices.labs.module02;
import neu.siddhartharaju.connecteddevices.labs.module02.TempEmulatorAdaptor;

public class DeviceHandlerApp extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Thread t1 = new Thread() {
			public void run()
			{
				System.out.println("Starting Thread");
				TempEmulatorAdaptor.run();
			}
		};
		t1.setDaemon(true);
		t1.start();
		while(true){}
				
	}

}
