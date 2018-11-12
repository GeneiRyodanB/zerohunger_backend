package com.zerohunger.models.actions;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zerohunger.models.users.User;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Action_Type")
public abstract class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long Id;
	
	@Column
    protected LocalDate date;
	@Column
    protected LocalTime time;
	@Column
    protected int nbPreparation;
	@Column
	protected int preparationReserve;
	@Column
    protected int nbDistribution;
	@Column 
	protected int distributionReserve;
	
	@OneToMany(
	        mappedBy = "action"
	)
    protected List<Participation> participations;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy_id")
    protected User createdBy;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
    protected Besoin besoin;

    public Action(){}

    public Action(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution) {
        this.date = date;
        this.time = time;
        this.nbPreparation = nbPreparation;
        this.nbDistribution = nbDistribution;
    }
    
    
    
    public Action(Long id, LocalDate date, LocalTime time, int nbPreparation, int nbDistribution,
			List<Participation> participations, User createdBy, Besoin besoin) {
		super();
		Id = id;
		this.date = date;
		this.time = time;
		this.nbPreparation = nbPreparation;
		this.nbDistribution = nbDistribution;
		this.createdBy = createdBy;
		this.participations = participations;
		this.besoin = besoin;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getNbPreparation() {
        return nbPreparation;
    }

    public void setNbPreparation(int nbPreparation) {
        this.nbPreparation = nbPreparation;
    }

    public int getNbDistribution() {
        return nbDistribution;
    }

    public void setNbDistribution(int nbDistribution) {
        this.nbDistribution = nbDistribution;
    }

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public Besoin getBesoin() {
		return besoin;
	}
	
	public void setBesoin(Besoin besoin) {
		this.besoin = besoin;
	}

	public int getPreparationReserve() {
		return preparationReserve;
	}

	public void setPreparationReserve(int preparationReserve) {
		this.preparationReserve = preparationReserve;
	}

	public int getDistributionReserve() {
		return distributionReserve;
	}

	public void setDistributionReserve(int distributionReserve) {
		this.distributionReserve = distributionReserve;
	}

	public boolean add(Participation arg0) {
		return participations.add(arg0);
	}

	public boolean addAll(Collection<? extends Participation> arg0) {
		return participations.addAll(arg0);
	}

	public void clear() {
		participations.clear();
	}

	public boolean contains(Object arg0) {
		return participations.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return participations.containsAll(arg0);
	}

	public Participation get(int arg0) {
		return participations.get(arg0);
	}

	public boolean isEmpty() {
		return participations.isEmpty();
	}

	public Participation remove(int arg0) {
		return participations.remove(arg0);
	}

	public boolean remove(Object arg0) {
		return participations.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return participations.removeAll(arg0);
	}

	public int size() {
		return participations.size();
	}

	@Override
	public String toString() {
		return "Action [Id=" + Id + ", date=" + date + ", time=" + time + ", nbPreparation=" + nbPreparation
				+ ", preparationReserve=" + preparationReserve + ", nbDistribution=" + nbDistribution
				+ ", distributionReserve=" + distributionReserve + ", participations=" + participations + ", createdBy="
				+ createdBy + ", besoin=" + besoin + "]";
	}
    
    

    
}
