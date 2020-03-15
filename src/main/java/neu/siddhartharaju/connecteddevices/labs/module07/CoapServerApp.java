package neu.siddhartharaju.connecteddevices.labs.module07;

public class CoapServerApp extends Thread{
	public static void main(String[] args)
	{
		CoapServerApp _App = new CoapServerApp();
		try {
			_App.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// private var's
	private CoapServerConnector _coapServer;
	// constructors
	public CoapServerApp()
	{
		super();
	}
	// Method to start the server initiation
	public void start()
	{
		_coapServer = new CoapServerConnector();
		_coapServer.start();
	}
}
