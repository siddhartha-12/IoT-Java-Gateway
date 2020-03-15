package neu.siddhartharaju.connecteddevices.labs.module07;
import java.net.InetSocketAddress;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;

public class CoapServerConnector
{
	// static
	private static final Logger _Logger = Logger.getLogger(CoapServerConnector.class.getName());
	// private var's
	private CoapServer _coapServer;
	// constructors
	public CoapServerConnector()
	{
		super();
	}
	// public methods

	
	public boolean addResource(CoapResource resource)
	 {
		 if (resource != null) 
		 {
		 _coapServer.add(resource);
		 }
		 return true;
	 }

	public void start()
	{
		if (_coapServer == null) {
			_Logger.info("Creating CoAP server instance");
			_coapServer = new CoapServer();		
		}
		TempResourceHandler trh = new TempResourceHandler("Temp");
		addResource(trh);
		_Logger.info("Added Resource");
		_coapServer.addEndpoint((new CoapEndpoint(new InetSocketAddress("127.0.0.1", 5683))));
		_Logger.info("Starting CoAP server...");
		_coapServer.start();
	}
	public boolean stop()
	{
		_Logger.info("Stopping CoAP server...");
		_coapServer.stop();
		return true;
	}


	public CoapServer get_coapServer() {
		return _coapServer;
	}


	public boolean set_coapServer() {
		this._coapServer = new CoapServer();
		return true;
	}
	
	
}
