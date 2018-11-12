package com.zerohunger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerohunger.models.actions.Action;
import com.zerohunger.services.FilActualiteService;

@RestController
public class FilActualiteController {

	@Autowired
	FilActualiteService filActualiteService;
	
	@RequestMapping(value = "/filActualite", method = RequestMethod.GET)
    public @ResponseBody List<Action> getActualite(){
        return filActualiteService.getActions();
        
    }
}
