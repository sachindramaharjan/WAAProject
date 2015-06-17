package mum.waaproject.service;

import mum.waaproject.model.User;

public interface UserService {
	
	User findOne(int userId);
}
