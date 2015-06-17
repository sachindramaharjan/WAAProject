package mum.waaproject.service;

import mum.waaproject.model.Store;
import mum.waaproject.model.User;

public interface StoreService {

	Store findOne(int storeId);
	Store findByUsername(User user);
	Store getStoreById(int id);
	
}
