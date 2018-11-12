package com.zerohunger.models.actions;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zerohunger.models.users.User;

@Entity
public class Participation {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
	@Column
	private ParticipationType  partiType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
	private User participant;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
	private Action action;
	
	@ElementCollection
	private Map<Article, Integer> articlesQuantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ParticipationType getPartiType() {
		return partiType;
	}

	public void setPartiType(ParticipationType partiType) {
		this.partiType = partiType;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Map<Article, Integer> getArticlesQuantity() {
		return articlesQuantity;
	}

	public void setArticlesQuantity(Map<Article, Integer> articlesQuantity) {
		this.articlesQuantity = articlesQuantity;
	}
	
	public Map<Article, Integer> buildArticlesQuantity(Map<String, Integer> map){
		Map<Article, Integer> builtMap = new HashMap<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			builtMap.put(Article.valueOf(entry.getKey()), entry.getValue());
		}
		return builtMap;
	}
	
	
}
