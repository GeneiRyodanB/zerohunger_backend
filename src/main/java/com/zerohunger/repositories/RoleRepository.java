package com.zerohunger.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zerohunger.models.users.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
