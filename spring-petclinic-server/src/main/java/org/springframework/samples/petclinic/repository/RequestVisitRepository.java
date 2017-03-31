package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.RequestVisit;

public interface RequestVisitRepository extends JpaRepository<RequestVisit, Integer>{	
	@Query("select v from RequestVisit v where v.owner.id=?1")
	List<RequestVisit> findByOwnerId(Integer ownerId); 

}
