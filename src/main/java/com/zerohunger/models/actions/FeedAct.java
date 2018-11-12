package com.zerohunger.models.actions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.zerohunger.models.sansabris.Coordonnee;
import com.zerohunger.models.users.User;

@Entity(name = "FeedAct")
@DiscriminatorValue("FeedAct")
public class FeedAct extends Action {
    
	
	@Column 
	private int achatReserve;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordonne_id")
    private Coordonnee meetingPoint;

    public FeedAct() {
    }

    public FeedAct(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution, Coordonnee meetingPoint) {
        super(date, time, nbPreparation, nbDistribution);
        this.meetingPoint = meetingPoint;
    }
    
    public void setMeetingPoint(Coordonnee meetingPoint) {
    	this.meetingPoint = meetingPoint;
    }
    
    public Coordonnee getMeetingPoint() {
    	return meetingPoint;
    }

	public int getAchatReserve() {
		return achatReserve;
	}

	public void setAchatReserve(int achatReserve) {
		this.achatReserve = achatReserve;
	}
     
}
