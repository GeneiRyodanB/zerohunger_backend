package com.zerohunger.models.actions;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.zerohunger.models.users.User;

@Entity(name = "FeedBike")
@DiscriminatorValue("FeedBike")
public class FeedBike extends Action {

	@Column
    private int nbCollecte;
	@Column 
	private int collecteReserve;
	

    public FeedBike() {
    }

    public FeedBike(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution, int nbCollecte) {
        super(date, time, nbPreparation, nbDistribution);
        this.nbCollecte = nbCollecte;
    }

    public int getNbCollecte() {
        return nbCollecte;
    }

    public void setNbCollecte(int nbCollecte) {
        this.nbCollecte = nbCollecte;
    }
    
    public int getCollecteReserve() {
    	return collecteReserve;
    }
    
    public void setCollecteReserve(int collecteReserve) {
    	this.collecteReserve = collecteReserve;
    }
}