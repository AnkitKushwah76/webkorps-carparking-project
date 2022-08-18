package Com.CarParkingManagement.Servlet;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {
	
	public static boolean EmailConform() {
		String i="10";
	String msg="Your Registration Success and Your Membership Number Is "+i;
	String subject="Registration Success Message.";
String to="ankitkushwahji159@gmail.com"; 
String from="ankukushwah76@gmail.com";
sendEmail(msg,subject,to,from);
return false;
	}
	public static boolean sendEmail(String msg,String subject,String to,String from) {
		Properties p=System.getProperties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");// 465 is default port number of g
		p.put("mail.smtp.ssl.enable", true);
		p.put("mail.smtp.auth", true);
		
		Session session=Session.getInstance(p,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ankukushwah76@gmail.com", "jopwzttmlibgecbu");
			}
		});
		session.setDebug(true);
		
		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(msg);
			Transport.send(m);
			System.out.println("Success Fully Send");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("hello");
		return false;
		
		
	}
	
	
}
