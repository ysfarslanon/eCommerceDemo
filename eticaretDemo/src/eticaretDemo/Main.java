package eticaretDemo;

import eticaretDemo.business.abstracts.UserService;
import eticaretDemo.business.concretes.UserManager;
import eticaretDemo.core.abstracts.LoginService;
import eticaretDemo.core.adapters.GoogleLoginManagerAbapter;
import eticaretDemo.core.concretes.MailSendHelper;
import eticaretDemo.dataAccess.abstracts.UserDao;
import eticaretDemo.dataAccess.concretes.InMemeoryUserDao;
import eticaretDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {	
		//3 adet constructorda olu�truludu�u i�in id 4 den ba�lat�lmal�d�r.
		User usrKontrolMail= new User(4, "MA�L HATASI", "VERECEK", "14arslan.yusuf@gmail.com", "1235456");
		User usrKontrolSifre= new User(5, "��FRE HATASI", "VERECEK", "SSSS@gmail.com", "421");
		User usrKontrolAdSoyad= new User(6, "A", "S", "yusuf@gmail.com", "145566");	
		User usrKontrolMailFormat= new User(7, "MA�L FORMATI HATASI", "VERECEK", "14arslan.yusuf@gmail.ars", "145566");
		User usrKontrolNullFields= new User(8, "", "", "", "");	
		User usrYusuf = new User(9,"Yusuf","Arslan","yusuf.arslan@gmail.com","123456");
		
		UserService usrManager = new UserManager(new InMemeoryUserDao(),new MailSendHelper());
		LoginService loginManager = new GoogleLoginManagerAbapter();
				
		
		usrManager.register(usrKontrolMail);
		usrManager.register(usrKontrolSifre);
		usrManager.register(usrKontrolAdSoyad);
		usrManager.register(usrKontrolMailFormat);
		usrManager.register(usrKontrolNullFields);
		
		usrManager.register(usrYusuf);
		usrManager.login(usrYusuf.getEmail(), usrYusuf.getPassword());
		loginManager.login(usrYusuf.getEmail(), usrYusuf.getPassword());
		
}
}