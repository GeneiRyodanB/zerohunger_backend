package com.zerohunger.models.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name = "role")
public class Role {

	public final static String BENEVOLE = "BENEVOLE";
	public final static String COORDINATEUR = "COORDINATEUR";
	public final static String ADMIN = "ADMIN";
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	
	private String role;
	
	@OneToMany(
	        mappedBy = "role"
	)
	private List<User> users;
	
	public Role(String role) {
		this.role =role;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
