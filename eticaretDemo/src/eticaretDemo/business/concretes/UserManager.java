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
			System.out.println("Kullanıcı eklendi. "+ user.getFirstName()+" "+user.getLastName() );
			sendMail.sendMail(user.getEmail(), " aktivasyon kodu gönderilmiştir.");
			user.setVerify(true);
			if(user.getVerify()) {
				System.out.println("Kullanıcı onaylanmıştır.");
			}else {
				System.out.println("Kullanıcı onaylanmadı.");
			}
			
		}else {
		System.out.println("Kullanıcı EKLENEMEDİ. >>> "+ user.getFirstName()+" "+user.getLastName());	
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
		System.out.println(result?"Giriş başarılı.":"Giriş başarısız.");		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);	
		System.out.println("Kullanıcı silindi. "+ user.getFirstName()+" "+user.getLastName());
	}

	@Override
	public void update(User user) {		
			userDao.update(user);
		System.out.println("Kullanıcı güncellenemedi.");		
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();		
	}		
	
	//-----------------------BUSİNESS RULES------------------------------------------
	private static boolean notNullFeilds(User user) {
		if(user.getEmail().length()>0&&user.getId()>=4&&user.getFirstName().length()>0
				&&user.getLastName().length()>0&&user.getPassword().length()>0) {
			return true;
		}
		System.out.println("Boş alan bırakmayınız.");
		return false;
	}
	
	
	private static boolean isPasswordLenght(User user) {
		if(user.getPassword().length()>=6) {			
			return true;
		}
		System.out.println("Parola 6 haneden küçük olamaz");
		return false;
	}
	
	private static boolean isFullnameLenght(User user) {
		if(user.getFirstName().length()>=2 &&user.getLastName().length()>=2) {			
			return true;
		}
		System.out.println("Adınız veya soyadınız 2 haneden küçük olamaz.");
		return false;
	}
	
	private static boolean isEmailValid(User user) {
		String emailPattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern =Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
		boolean result= pattern.matcher(user.getEmail()).find();
		if (result) {
			return true;
			}
		System.out.println("Mail format hatası.");
		return false;
	}
	
	private  boolean isEmailExists(User user) {
		//Mail sistemde varsa true dönecektir.Yoksa false dolayısıyla Kontrol ederken !isEmailExist(user) kullanmak zorundayız.
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
