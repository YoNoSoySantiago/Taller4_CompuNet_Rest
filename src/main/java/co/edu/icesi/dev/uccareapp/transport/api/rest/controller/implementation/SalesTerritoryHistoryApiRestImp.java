package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.SalesTerritoryHistoryApiRest;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritoryhistory;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.SalesTerritoryHistoryService;

@RestController
public class SalesTerritoryHistoryApiRestImp implements SalesTerritoryHistoryApiRest{

	@Autowired
	private SalesTerritoryHistoryService salesTerritoryHistoryService;
	
	@Override
	@PostMapping("/api/sales_territory_history/")
	public void save(@RequestBody Salesterritoryhistory s) throws InvalidValueException, ObjectDoesNotExistException, ObjectAlreadyExistException {
		salesTerritoryHistoryService.add(s,
				s.getSalesPerson().getBusinessentityid(),
				s.getSalesTerritory().getTerritoryid());
	}

	@Override
	@PutMapping("/api/sales_territory_history/{id}")
	public void update(@RequestBody Salesterritoryhistory s, @PathVariable("id") Integer id) throws InvalidValueException, ObjectDoesNotExistException {
		salesTerritoryHistoryService.edit(s);
	}

	@Override
	@DeleteMapping("/api/sales_territory_history/{id}")
	public void delete(@PathVariable("id") Integer id) {
		salesTerritoryHistoryService.delete(id);
	}

	@Override
	@GetMapping("/api/sales_territory_history/{id}")
	public Salesterritoryhistory findById(@PathVariable("id") Integer id) {
		return salesTerritoryHistoryService.findById(id).get();
	}

	@Override
	@GetMapping("/api/sales_territory_history/")
	public Iterable<Salesterritoryhistory> findAll() {
		return salesTerritoryHistoryService.findAll();
	}

}
