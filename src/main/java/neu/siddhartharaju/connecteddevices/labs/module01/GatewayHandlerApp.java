package neu.siddhartharaju.connecteddevices.labs.module01;

public class GatewayHandlerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i<15)
			{
				
				SystemPerformanceAdaptor.getPerformance();
			try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				
			}
	}

}
