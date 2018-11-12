package com.zerohunger.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zerohunger.models.users.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByTel(String tel);
	
	boolean existsByTel(String tel);
	
	boolean existsByEmail(String email);
}
