package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UtilMail {
	private final Properties properties = new Properties();
	
	private String password = "ravioliadmin";
	private Session session;
	
	private String emisor = "pizeriaravioli@gmail.com";
	private String receptor;
	
	private void init() {

		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",465);
		properties.put("mail.smtp.mail.sender",emisor);
		properties.put("mail.smtp.user", emisor);
		properties.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(properties);
	}

	public void sendEmail(String Mensaje){

		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			message.setSubject("Recuperacion de Cuenta");
			message.setText(Mensaje);
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			throw new RuntimeException(me.getMessage());
		}
		
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
}
