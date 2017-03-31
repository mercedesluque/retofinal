package org.springframework.samples.petclinic.service;

import java.util.List;
import org.springframework.samples.petclinic.model.RequestVisit;

public interface RequestVisitService {
	List<RequestVisit> findAll(); 
	
	List<RequestVisit> findByOwnerId(Integer ownerId); 

	RequestVisit save(RequestVisit requestVisit);
}
