package eticaretDemo.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import eticaretDemo.dataAccess.abstracts.UserDao;
import eticaretDemo.entities.concretes.User;

public class InMemeoryUserDao implements UserDao{

	private List<User> users;
	
	public InMemeoryUserDao() {
		users=new ArrayList<User>();
		users.add(new User(0,"Yusuf","Arslan","14arslan.yusuf@gmail.com","123456"));
		users.add(new User(1,"Altay","Bayýdýr","altay.bayirdir.@gmail.com","123456"));
		users.add(new User(2,"Attila","Szalai","atilla.szalai@outlook.com","123456"));
	}	
	
	@Override
	public void add(User user) {
		users.add(user);		
	}

	@Override
	public void update(User user) { 
		System.out.println("Kullanýcý güncellendi. "+user.getEmail());
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

	@Override
	public User getById(int id) {			
		return users.get(id);	
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
