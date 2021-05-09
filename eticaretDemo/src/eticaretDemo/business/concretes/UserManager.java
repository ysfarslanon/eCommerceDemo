package eticaretDemo.business.concretes;


import java.util.List;
import java.util.regex.Pattern;

import eticaretDemo.business.abstracts.UserService;
import eticaretDemo.core.abstracts.SendMailService;
import eticaretDemo.dataAccess.abstracts.UserDao;
import eticaretDemo.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private SendMailService sendMail;
	public UserManager(UserDao userDao,SendMailService sendMail) {
		this.userDao = userDao;
		this.sendMail=sendMail;
	}	

	@Override
	public void register(User user) {		
		if (notNullFeilds(user)&&isPasswordLenght(user)&&isFullnameLenght(user)&& isEmailValid(user)&&!isEmailExists(user)) {
			userDao.add(user);
			System.out.println("Kullan�c� eklendi. "+ user.getFirstName()+" "+user.getLastName() );
			sendMail.sendMail(user.getEmail(), " aktivasyon kodu g�nderilmi�tir.");
			user.setVerify(true);
			if(user.getVerify()) {
				System.out.println("Kullan�c� onaylanm��t�r.");
			}else {
				System.out.println("Kullan�c� onaylanmad�.");
			}
			
		}else {
		System.out.println("Kullan�c� EKLENEMED�. >>> "+ user.getFirstName()+" "+user.getLastName());	
		}
	}
	
	@Override
	public void login(String mail, String password) {
		boolean result=false;
		for(int i=0;i<this.getAll().size();i++) {
			if (mail==this.getById(i).getEmail()&&password==this.getById(i).getPassword()) {
				result=true;
			}
		}
		System.out.println(result?"Giri� ba�ar�l�.":"Giri� ba�ar�s�z.");		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);	
		System.out.println("Kullan�c� silindi. "+ user.getFirstName()+" "+user.getLastName());
	}

	@Override
	public void update(User user) {		
			userDao.update(user);
		System.out.println("Kullan�c� g�ncellenemedi.");		
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();		
	}		
	
	//-----------------------BUS�NESS RULES------------------------------------------
	private static boolean notNullFeilds(User user) {
		if(user.getEmail().length()>0&&user.getId()>=4&&user.getFirstName().length()>0
				&&user.getLastName().length()>0&&user.getPassword().length()>0) {
			return true;
		}
		System.out.println("Bo� alan b�rakmay�n�z.");
		return false;
	}
	
	
	private static boolean isPasswordLenght(User user) {
		if(user.getPassword().length()>=6) {			
			return true;
		}
		System.out.println("Parola 6 haneden k���k olamaz");
		return false;
	}
	
	private static boolean isFullnameLenght(User user) {
		if(user.getFirstName().length()>=2 &&user.getLastName().length()>=2) {			
			return true;
		}
		System.out.println("Ad�n�z veya soyad�n�z 2 haneden k���k olamaz.");
		return false;
	}
	
	private static boolean isEmailValid(User user) {
		String emailPattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern =Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
		boolean result= pattern.matcher(user.getEmail()).find();
		if (result) {
			return true;
			}
		System.out.println("Mail format hatas�.");
		return false;
	}
	
	private  boolean isEmailExists(User user) {
		//Mail sistemde varsa true d�necektir.Yoksa false dolay�s�yla Kontrol ederken !isEmailExist(user) kullanmak zorunday�z.
		boolean result=false;			
		for(int i=0;i<this.getAll().size();i++) {
			if(user.getEmail()==this.getById(i).getEmail()) {			
			result =true;
			}			
		}			
		System.out.println(result?"Mail sistemde mevcuttur.":"");
		return result;
		
	}

	

}
