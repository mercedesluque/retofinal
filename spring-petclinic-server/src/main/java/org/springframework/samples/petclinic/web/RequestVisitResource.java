package org.springframework.samples.petclinic.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.RequestVisit;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.service.ClinicServiceImpl;
import org.springframework.samples.petclinic.service.RequestVisitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestVisitResource extends AbstractResourceController {

	@Autowired
	private RequestVisitService requestVisitService ;
	
	@Autowired
	private ClinicServiceImpl clinicService;
	
	@Autowired
	public RequestVisitResource(RequestVisitService requestVisitService) {
		this.requestVisitService = requestVisitService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/request-visits", method = RequestMethod.POST)
	//@PostMapping(value = "/owners/{ownerId}/pets/{petId}/request-visits")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@RequestBody RequestVisitInput requestVisitInput,
						@PathVariable("ownerId") int ownerId,
						@PathVariable("petId") int petId) {
		Owner owner = clinicService.findOwnerById(ownerId);
		Pet pet = clinicService.findPetById(petId);
		Vet vet = clinicService.findVetById(requestVisitInput.getVetId());
		
		RequestVisit requestVisit = new RequestVisit();
		requestVisit.setDate(requestVisitInput.getDate());
		requestVisit.setId(requestVisit.getId());
		requestVisit.setOwner(owner);
		requestVisit.setPet(pet);
		requestVisit.setVet(vet);
		requestVisit.setState(0);
		requestVisitService.save(requestVisit);
	}
	
	
	
	@RequestMapping(value="/owner/{ownerId}/requestvisits", method=RequestMethod.GET)
	//@GetMapping("/owner/{ownerId}/requestvisits")
	public Object requestVisits(@PathVariable("ownerId") int ownerId) {
		List<RequestVisit> res = null;
		res = this.requestVisitService.findByOwnerId(ownerId);
		return res;
	}
	
	static class RequestVisitInput {
		int id;
		Date date;
		int vetId;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getVetId() {
			return vetId;
		}
		public void setVetId(int vetId) {
			this.vetId = vetId;
		}	
	}
}