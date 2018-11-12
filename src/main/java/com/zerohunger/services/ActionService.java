package com.zerohunger.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerohunger.models.actions.Action;
import com.zerohunger.models.actions.Article;
import com.zerohunger.models.actions.FeedAct;
import com.zerohunger.models.actions.FeedBike;
import com.zerohunger.models.actions.Participation;
import com.zerohunger.models.actions.ParticipationType;
import com.zerohunger.models.users.User;
import com.zerohunger.repositories.ActionRepository;
import com.zerohunger.repositories.ParticipationRepository;
import com.zerohunger.repositories.UserRepository;

import static com.zerohunger.config.MessageConstant.MESSAGE;
import static com.zerohunger.config.MessageConstant.PARTICIPATED;
import static com.zerohunger.config.MessageConstant.ALREADY_PARTICIPATED;
import static com.zerohunger.config.MessageConstant.ACTION_NOT_FOUND;


@Service
public class ActionService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ActionRepository actionRepository;
	
	@Autowired
	private ParticipationRepository participationRepository;
	
	public int saveAction(Action action) {
		Long userId = (Long)session.getAttribute("userId");
		Optional<User> userResult = userRepository.findById(userId);
		User user;
		if(userResult.isPresent()) {
			user = userResult.get();
			action.setCreatedBy(user);
			action.setDistributionReserve(0);
			action.setNbPreparation(0);
			if(action instanceof FeedBike) {
				((FeedBike)action).setCollecteReserve(0);
			} else if(action instanceof FeedAct) {
				((FeedAct)action).setAchatReserve(0);
			}
			if (actionRepository.save(action) != null) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	public Map<String, String> participate(Map<String, Object> participationMap) {
		Map<String, String> response = new HashMap<>();
		Participation participation = new Participation();
		String userTel = (String)participationMap.get("userTel");
		User participant = userRepository.findByTel(userTel);
		ParticipationType participationType = ParticipationType.valueOf((String) participationMap.get("participationType"));
		Long actionId = Long.valueOf((String) participationMap.get("actionId"));
		Optional<Action> actionResult = actionRepository.findById(actionId);
		Action action = null;
		if(actionResult.isPresent()) {
			action = actionResult.get();
			if(!verifyIfParticiped(participant.getId(), action.getId(), participationType)) {
				Map<String, Integer> articQuantMap = (HashMap)participationMap.get("artcilesQuatity");
				Map<Article, Integer> articlesQuantity = participation.buildArticlesQuantity(articQuantMap);
				participation.setParticipant(participant);
				participation.setAction(action);
				participation.setPartiType(participationType);
				participation.setArticlesQuantity(articlesQuantity);
				participationRepository.save(participation);
				response.put(MESSAGE, PARTICIPATED);
			} else {
				response.put(MESSAGE, ALREADY_PARTICIPATED);
			}
			
		} else {
			response.put(MESSAGE, ACTION_NOT_FOUND);
		}
		
		return response;
	}
	
	public Optional<Action> getActionById(long id) {
		return actionRepository.findById(id);
	}
	
	public boolean verifyIfParticiped(Long participantId, Long actionId, ParticipationType participationType) {
		List<Long> partiIds =  participationRepository.findByParticipantAndType(participantId, actionId, participationType);
		return (partiIds != null && !partiIds.isEmpty());
	}
	
	public Participation getParticipation(int partId) {
		Optional<Participation> participation = participationRepository.findById((long) partId);
		return null;
	}
	
}
