package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.CurrencyRateApiRest;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.CurrencyRateService;

@RestController
public class CurrencyRateApiRestImp implements CurrencyRateApiRest{

	@Autowired
	private CurrencyRateService currencyRateService;
	
	@Override
	@PostMapping("/api/currency_rate/")
	public void save(@RequestBody Currencyrate c) {
		currencyRateService.add(c);
	}

	@Override
	@PutMapping("/api/currency_rate/{id}")
	public void update(@RequestBody Currencyrate c, @PathVariable("id") Integer id) {
		currencyRateService.edit(c);
	}

	@Override
	@DeleteMapping("/api/currency_rate/{id}")
	public void delete(@PathVariable("id") Integer id) {
		currencyRateService.delete(id);
	}

	@Override
	@GetMapping("/api/currency_rate/{id}")
	public Currencyrate findById(@PathVariable("id") Integer id) {
		return currencyRateService.findById(id).get();
	}

	@Override
	@GetMapping("/api/currency_rate/")
	public Iterable<Currencyrate> findAll() {
		return currencyRateService.findAll();
	}

}
