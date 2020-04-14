package neu.siddhartharaju.connecteddevices.project;
import java.io.IOException;
import neu.siddhartharaju.connecteddevices.common.ConfigUtil;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

public class SmtpClientConnector {
	
	private ConfigUtil config;
	
	//Connecting SMTP client
	public SmtpClientConnector() {
		super();
		// TODO Auto-generated constructor stub
		try {
			this.config = new ConfigUtil();
			this.config.loadConfig("config\\ConnectedDevicesConfig.props");
			//System.out.println("Config Loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	//Generating mail body and sending it
	public boolean publishMessage(String topic,String data)
	{
		final String username = "iotsiddhartha";
        final String password = config.getValue("smtp.cloud","authToken");
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", config.getValue("smtp.cloud","host"));
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        try {
        	//Generating mail body
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.getValue("smtp.cloud","fromAddr")));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(config.getValue("smtp.cloud","toAddr")));
            message.setSubject(topic);
            message.setText(data);
            Transport.send(message);
            //System.out.println("Done");
            return true;

        } catch (MessagingException e) {
        	System.out.println(e.toString());
            return false;
        }
        }
}
