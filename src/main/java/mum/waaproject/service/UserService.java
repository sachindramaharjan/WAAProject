package mum.waaproject.service;

import java.util.List;

import mum.waaproject.model.User;

public interface UserService {
	
	User findOne(int userId);
	
	public void save(User user);

	public List<User> getAll();
	

}
