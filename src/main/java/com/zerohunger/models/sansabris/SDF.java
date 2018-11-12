package com.zerohunger.models.sansabris;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zerohunger.models.users.User;

@Entity
public class SDF {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordonnee_id")
    private Coordonnee coordonnee;
    
    private String nom;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User markedBy;

    public SDF() {}
    
    public SDF(Coordonnee coordonnee, String nom) {
        this.coordonnee = coordonnee;
        this.nom = nom;
    }
    
    

    public SDF(Long id, Coordonnee coordonnee, String nom, User markeddBy) {
		super();
		this.id = id;
		this.coordonnee = coordonnee;
		this.nom = nom;
		this.markedBy = markeddBy;
	}

	public User getMarkeddBy() {
		return markedBy;
	}

	public void setMarkeddBy(User markeddBy) {
		this.markedBy = markeddBy;
	}

	public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
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

    @Override
    public String toString() {
        return "SDF{" +
                "coordonnee=" + coordonnee +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SDF sdf = (SDF) o;
        return Objects.equals(coordonnee, sdf.coordonnee) &&
                Objects.equals(nom, sdf.nom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(coordonnee, nom);
    }
}

