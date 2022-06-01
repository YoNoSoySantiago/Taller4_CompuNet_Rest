package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.SalesPersonQuotaHistoryApiRest;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salespersonquotahistory;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.SalesPersonQuotaHistoryService;

@RestController
public class SalesPersonQuotaHistoryApiRestImp implements SalesPersonQuotaHistoryApiRest{

	@Autowired
	private SalesPersonQuotaHistoryService salesPersonQuotaHistoryService;
	
	@Override
	@PostMapping("/api/sales_person_quota_history/")
	public void save(@RequestBody Salespersonquotahistory s) throws InvalidValueException, ObjectAlreadyExistException, ObjectDoesNotExistException {
		salesPersonQuotaHistoryService.add(s, s.getSalesperson().getBusinessentityid());
	}

	@Override
	@PutMapping("/api/sales_person_quota_history/{id}")
	public void update(@RequestBody Salespersonquotahistory s, @PathVariable("id") Integer id) throws InvalidValueException, ObjectDoesNotExistException {
		salesPersonQuotaHistoryService.edit(s);
	}

	@Override
	@DeleteMapping("/api/sales_person_quota_history/{id}")
	public void delete(@PathVariable("id") Integer id) {
		salesPersonQuotaHistoryService.delete(id);
	}

	@Override
	@GetMapping("/api/sales_person_quota_history/{id}")
	public Salespersonquotahistory findById(@PathVariable("id") Integer id) {
		return salesPersonQuotaHistoryService.findById(id).get();
	}

	@Override
	@GetMapping("/api/sales_person_quota_history/")
	public Iterable<Salespersonquotahistory> findAll() {
		return salesPersonQuotaHistoryService.findAll();
	}

}
