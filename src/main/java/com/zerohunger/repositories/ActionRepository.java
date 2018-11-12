package com.zerohunger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerohunger.models.actions.Action;

public interface ActionRepository extends JpaRepository<Action, Long>{

}
