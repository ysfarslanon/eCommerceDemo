package eticaretDemo.business.abstracts;

import java.util.List;

import eticaretDemo.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(String mail,String password);
	void delete(User user);
	void update(User user);
	User getById(int id);
	List<User> getAll();
	
}
