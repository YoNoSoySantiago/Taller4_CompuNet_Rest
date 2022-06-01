package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.SalesTerritoryApiRest;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritory;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.SalesTerritoryService;

@RestController
public class SalesTerritoryApiRestImp implements SalesTerritoryApiRest{

	@Autowired
	private SalesTerritoryService salesTerritoryService;
	
	@Override
	@PostMapping("/api/sales_territory/")
	public void save(@RequestBody Salesterritory s) throws InvalidValueException, ObjectDoesNotExistException {
		salesTerritoryService.add(s);
	}

	@Override
	@PutMapping("/api/sales_territory/{id}")
	public void update(@RequestBody Salesterritory s, @PathVariable("id") Integer id) throws InvalidValueException, ObjectDoesNotExistException {
		salesTerritoryService.edit(s);
	}

	@Override
	@DeleteMapping("/api/sales_territory/{id}")
	public void delete(@PathVariable("id") Integer id) {
		salesTerritoryService.delete(id);
	}

	@Override
	@GetMapping("/api/sales_territory/{id}")
	public Salesterritory findById(@PathVariable("id") Integer id) {
		return salesTerritoryService.findById(id).get();
	}

	@Override
	@GetMapping("/api/sales_territory/")
	public Iterable<Salesterritory> findAll() {
		return salesTerritoryService.findAll();
	}

}
