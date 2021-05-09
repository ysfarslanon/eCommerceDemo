package eticaretDemo.core.adapters;

import eticaretDemo.core.abstracts.LoginService;
import eticaretDemo.external.GoogleLoginManager;

public class GoogleLoginManagerAbapter implements LoginService{

	@Override
	public void login(String mail, String password) {
		GoogleLoginManager manager = new GoogleLoginManager();
		manager.loginWithGoogle(mail, password);
		
	}
	
}
