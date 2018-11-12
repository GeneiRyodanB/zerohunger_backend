package com.zerohunger.models.users;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.zerohunger.models.actions.Action;
import com.zerohunger.models.actions.Participation;
import com.zerohunger.models.sansabris.SDF;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
    private String nom;
    private String email;
    private String tel;
    private String ville;
    private String password;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    
    @OneToMany(
	        mappedBy = "createdBy"
	)
    private List<Action> mesActions;
    
    @OneToMany(
	        mappedBy = "participant"
	)
    private List<Participation> participations;
    
    @OneToMany(
	        mappedBy = "markedBy"
	)
    private List<SDF> sansAbris;

    public User() {}

    public User(String nom, String email, String tel, String ville, String password, Role role) {
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.ville = ville;
        this.password = password;
        this.role = role;
    }
    
    

    public User(Long id, String nom, String email, String tel, String ville, String password, Role role,
			List<Action> mesActions, List<SDF> sansAbris) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.ville = ville;
		this.password = password;
		this.role = role;
		this.mesActions = mesActions;
		this.sansAbris = sansAbris;
	}

    public User(Long id, String nom, String email, String tel, String ville, String password, Role role,
			List<Action> mesActions, List<SDF> sansAbris, List<Participation> participations) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.ville = ville;
		this.password = password;
		this.role = role;
		this.mesActions = mesActions;
		this.sansAbris = sansAbris;
		this.participations = participations;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int participerAction(Action action){
        return 0;
    }
    
    public void setRole(Role role) {
    	this.role = role;
    }
    
    public Role getRole() {
    	return role;
    }
    
    public void setMesActions(List<Action> mesActions) {
    	this.mesActions = mesActions;
    }
    
    public List<Action> getMesActions(){
    	return mesActions;
    }
    
    public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public void setSansAbris(List<SDF> sansAbris) {
    	this.sansAbris = sansAbris;
    }

    public List<SDF> getSansAbris(){
    	return sansAbris;
    }
    
    public void minimizeInfo() {
    	id = null;
    	password = "";
    	mesActions = null;
    	participations = null;
    	sansAbris = null;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", ville='" + ville + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nom, user.nom) &&
                Objects.equals(email, user.email) &&
                Objects.equals(tel, user.tel) &&
                Objects.equals(ville, user.ville) &&
                Objects.equals(password, user.password) &&
        		Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nom, email, tel, ville, password, role);
    }

}
