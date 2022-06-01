package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.SalesPersonApiRest;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesperson;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.SalesPersonService;

@RestController
public class SalesPersonApiRestImp implements SalesPersonApiRest{

	@Autowired
	private SalesPersonService salesPersonService;
	
	@Override
	@PostMapping("/api/sales_person/")
	public void save(@RequestBody Salesperson s) throws InvalidValueException, ObjectAlreadyExistException, ObjectDoesNotExistException {
		salesPersonService.add(s, s.getBusinessentityid(), s.getSalesterritory().getTerritoryid());
	}

	@Override
	@PutMapping("/api/sales_person/{id}")
	public void update(@RequestBody Salesperson s, @PathVariable("id") Integer id) throws InvalidValueException, ObjectDoesNotExistException {
		salesPersonService.edit(s);
	}

	@Override
	@DeleteMapping("/api/sales_person/{id}")
	public void delete(@PathVariable("id") Integer id) {
		salesPersonService.delete(id);
	}

	@Override
	@GetMapping("/api/sales_person/{id}")
	public Salesperson findById(@PathVariable("id") Integer id) {
		return salesPersonService.findById(id).get();
	}

	@Override
	@GetMapping("/api/sales_person/")
	public Iterable<Salesperson> findAll() {
		return salesPersonService.findAll();
	}

}
