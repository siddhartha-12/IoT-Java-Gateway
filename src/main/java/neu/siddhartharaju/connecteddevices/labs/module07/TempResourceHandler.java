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
	/*
	 * Overloaded methods 
	 * HandleGet method to handle all the get requests coming to the server
	 */
	@Override
	 public void handleGET(CoapExchange ce)
	 {
	 ce.respond(ResponseCode.VALID,ce.getRequestPayload());
	 _Logger.info("Received GET request from client.");
	 }
	//handlePOST method to handle all the post requests coming to the server
	@Override
	public void handlePOST(CoapExchange ce) {
		ce.respond(ResponseCode.CREATED, "POST worked!");
		 _Logger.info("Received POST request from client.");
	}
	//handlePUT method to handle all the put requests coming to the server
	@Override
	public void handlePUT(CoapExchange ce) {
		ce.respond(ResponseCode.CHANGED, "PUT worked!");
		 _Logger.info("Received PUT request from client.");
	}
	//handleDELETE method to handle all the delete requests coming to the server
	@Override
	public void handleDELETE(CoapExchange ce) {
		ce.respond(ResponseCode.DELETED, "Delete worked!");
		 _Logger.info("Received DELETE request from client.");
	}
}
