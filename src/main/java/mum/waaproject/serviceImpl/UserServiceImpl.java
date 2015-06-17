package mum.waaproject.serviceImpl;

import mum.waaproject.model.User;
import mum.waaproject.repository.UserRepository;
import mum.waaproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findOne(int userId) {
		return userRepository.findOne(userId);
	}

	
}
