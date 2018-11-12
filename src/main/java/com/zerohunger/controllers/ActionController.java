package com.zerohunger.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerohunger.models.actions.Action;
import com.zerohunger.models.actions.FeedAct;
import com.zerohunger.models.actions.FeedBike;
import com.zerohunger.models.actions.Participation;
import com.zerohunger.services.ActionService;

@RestController
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	
	@PostMapping(path="/postAction")
	public @ResponseBody int postAction(@RequestBody Action action) {
		return actionService.saveAction(action);
	}
	
	/*@PostMapping(path="/postFeedBike")
	public @ResponseBody int postFeedBike(@RequestBody FeedBike action) {
		return actionService.saveAction(action);
	}*/
	
	@PostMapping(path="/particpateToAction")
	public @ResponseBody Map<String, String> participateToAction(@RequestBody Map<String, Object> participationMap) {
		return actionService.participate(participationMap);
	}
	
	
	@PostMapping(path="/getParticipation")
	public @ResponseBody Participation findParticipation(@RequestBody int partId) {
		return actionService.getParticipation(partId);
	}
}
