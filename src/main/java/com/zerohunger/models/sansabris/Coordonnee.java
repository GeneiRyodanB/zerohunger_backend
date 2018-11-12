package com.zerohunger.models.sansabris;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.zerohunger.models.actions.FeedAct;

@Entity
public class Coordonnee {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@OneToMany(
	        mappedBy = "meetingPoint"
	)
	private List<FeedAct> feedActActions;
	
	@OneToMany(
	        mappedBy = "coordonnee"
	)
	private List<SDF> sansAbris;
	
    private double longitude;
    private double latitude;
    
    public Coordonnee() {}

    public Coordonnee(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public void setSansAbris(List<SDF> sansAbris) {
    	this.sansAbris = sansAbris;
    }
    
    public List<SDF> getSansAbris(){
    	return sansAbris;
    }
    
    public void setFeedActActions(List<FeedAct> feedActActions) {
    	this.feedActActions = feedActActions;
    }
    
    public List<FeedAct> getFeedActActions(){
    	return feedActActions;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Coordonnee{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(longitude, latitude);
    }
}

