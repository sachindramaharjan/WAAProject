package mum.waaproject.serviceImpl;

import mum.waaproject.model.Store;
import mum.waaproject.model.User;
import mum.waaproject.repository.StoreRepository;
import mum.waaproject.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public Store findOne(int storeId) {
		return storeRepository.findOne(storeId);
	}

	@Override
	public Store findByUsername(User user) {
		return storeRepository.findByUsername(user);
	}
	
}
	