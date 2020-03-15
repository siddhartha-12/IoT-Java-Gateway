package neu.siddhartharaju.connecteddevices.labs.module07;
import java.util.logging.Logger;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class TempResourceHandler extends CoapResource{

	public TempResourceHandler(String name) {
		super(name, true);
		// TODO Auto-generated constructor stub
	}

	// static
	private static final Logger _Logger =
			Logger.getLogger(TempResourceHandler.class.getName());
	// constructors
	
	@Override
	 public void handleGET(CoapExchange ce)
	 {
	 ce.respond(ResponseCode.VALID, "GET worked!");
	 _Logger.info("Received GET request from client.");
	 }

	@Override
	public void handlePOST(CoapExchange ce) {
		ce.respond(ResponseCode.CREATED, "POST worked!");
		 _Logger.info("Received POST request from client.");
	}

	@Override
	public void handlePUT(CoapExchange ce) {
		ce.respond(ResponseCode.CHANGED, "PUT worked!");
		 _Logger.info("Received PUT request from client.");
	}

	@Override
	public void handleDELETE(CoapExchange ce) {
		ce.respond(ResponseCode.DELETED, "Delete worked!");
		 _Logger.info("Received DELETE request from client.");
	}

}
