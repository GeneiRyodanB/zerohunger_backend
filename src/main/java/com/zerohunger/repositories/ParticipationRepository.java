package com.zerohunger.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zerohunger.models.actions.Participation;
import com.zerohunger.models.actions.ParticipationType;

public interface ParticipationRepository extends JpaRepository<Participation, Long>{

	@Query(value="select p.id from Participation p where p.participant.id = ?1 and p.action.Id = ?2 and p.partiType = ?3")
	List<Long> findByParticipantAndType(Long participantId, Long actionId, ParticipationType participationtype);
}
