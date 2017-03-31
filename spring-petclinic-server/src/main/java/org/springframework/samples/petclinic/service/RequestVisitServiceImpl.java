package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.RequestVisit;
import org.springframework.samples.petclinic.repository.RequestVisitRepository;
import org.springframework.stereotype.Service;
@Service
public class RequestVisitServiceImpl implements RequestVisitService {
	 	private RequestVisitRepository requestVisitRepository;

	    @Autowired
	    public RequestVisitServiceImpl(RequestVisitRepository requestVisitRepository) {
	        this.requestVisitRepository = requestVisitRepository;
	    }

	@Override
	public List<RequestVisit> findAll() {
		return requestVisitRepository.findAll();
	}

	@Override
	public List<RequestVisit> findByOwnerId(Integer ownerId) {
		return requestVisitRepository.findByOwnerId(ownerId);
	}

	@Override
	public RequestVisit save(RequestVisit requestVisit) {
		return requestVisitRepository.save(requestVisit);
	}

}
