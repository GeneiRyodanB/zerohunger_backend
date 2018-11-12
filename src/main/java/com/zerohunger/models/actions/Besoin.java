package com.zerohunger.models.actions;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Besoin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long Id;

	@ElementCollection
	private Map<Article, Integer> articlesQuantity;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
	private Action action;
	
	public Besoin() {
		
	}
	
	public Besoin(Long Id, Map<Article, Integer> articlesQuantity, Action action) {
		this.Id = Id;
		this.articlesQuantity = articlesQuantity;
		this.action = action;
	}

	public Map<Article, Integer> getArticlesQuantity() {
		return articlesQuantity;
	}

	public void setArticlesQuantity(Map<Article, Integer> articlesQuantity) {
		this.articlesQuantity = articlesQuantity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int size() {
		return articlesQuantity.size();
	}

	public boolean isEmpty() {
		return articlesQuantity.isEmpty();
	}

	public Integer get(Object key) {
		return articlesQuantity.get(key);
	}

	public Integer put(Article key, Integer value) {
		return articlesQuantity.put(key, value);
	}

	public Integer remove(Object key) {
		return articlesQuantity.remove(key);
	}

	public void putAll(Map<? extends Article, ? extends Integer> m) {
		articlesQuantity.putAll(m);
	}

	public void clear() {
		articlesQuantity.clear();
	}
	
	
	
	
}
