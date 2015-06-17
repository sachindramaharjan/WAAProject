package mum.waaproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import mum.waaproject.model.User;
import mum.waaproject.model.UserRole;
import mum.waaproject.repository.UserRepository;
import mum.waaproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private UserRoleRepository userRoleRepository;
	
	@Override
	public User findOne(int userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public void save(User user) {
		user.setEnabled(1);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        
//        List<UserRole> roles = new ArrayList<UserRole>();
//        roles.add(userRoleRepository.findByName("ROLE_USER"));
        
        userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return (List<User>)userRepository.findAll();
	}
	
	
}
