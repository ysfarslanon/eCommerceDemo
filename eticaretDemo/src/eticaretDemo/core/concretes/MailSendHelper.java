package eticaretDemo.core.concretes;

import eticaretDemo.core.abstracts.SendMailService;

public class MailSendHelper implements SendMailService{

	@Override
	public void sendMail(String mail, String message) {
		System.out.println(mail+" "+message);		
	}

}
