package net.tncy.hackatrip;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import net.tncy.entity.Travel;

public class InvitationMail {
	public static void send(String mail, Travel travel) {

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		if(user != null){
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);
			
			String msgBody = "Bonjour,\n" +
					"\n" +
					user.getNickname()+" a le plaisir de vous inviter au voyage '"+travel.getName()+"' !" +
							"Vous pouvez participer à la préparation de cet évenement ici : http://hackatrip.appspot.com/DisplayTravel?id="+travel.getId() + " \n" +
							"\n" +
							"A bientôt, sur Hack a trip!";
			try{
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(user.getEmail(), "Invitation Hack a Trip"));
				msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress(mail, "Invité"));
				msg.setSubject(user.getNickname()+" vous invite à voyager, depuis le site Hackatrip.appspot.com");
				msg.setText(msgBody);
				Transport.send(msg);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}