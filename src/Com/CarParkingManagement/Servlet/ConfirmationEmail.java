package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConfirmationEmail")
public class ConfirmationEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	public static void  sendEmail(String msg,String subject,String to,String from) {
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
			MimeMessage mimemessage = new MimeMessage(session);
			mimemessage.setFrom(new InternetAddress(from));
			mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimemessage.setSubject(subject);
			mimemessage.setText(msg);
			Transport.send(mimemessage);
			
			System.out.println("Success Fully Send");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
	}

}
