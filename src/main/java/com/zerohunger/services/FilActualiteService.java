package com.zerohunger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerohunger.models.actions.Action;
import com.zerohunger.repositories.ActionRepository;

@Service
public class FilActualiteService {

	@Autowired
	ActionRepository actionRepository;
	
	public List<Action> getActions(){
		return actionRepository.findAll();
	}
}
