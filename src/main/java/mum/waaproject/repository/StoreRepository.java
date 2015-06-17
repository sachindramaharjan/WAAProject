package mum.waaproject.repository;

import mum.waaproject.model.Store;
import mum.waaproject.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

	@Query("select s from store s where s.user = :user")
	Store findByUsername(@Param("user") User user);
	
}
