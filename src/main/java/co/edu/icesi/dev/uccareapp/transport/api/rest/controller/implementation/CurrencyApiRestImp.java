package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces.CurrencyApiRest;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.CurrencyService;

@RestController
public class CurrencyApiRestImp implements CurrencyApiRest {

	@Autowired
	private CurrencyService currencyService;
	
	@Override
	@PostMapping("/api/currency/")
	public void save(@RequestBody Currency c) {
		currencyService.add(c);
	}

	@Override
	@PutMapping("/api/currency/{cod}")
	public void update(@RequestBody Currency c, @PathVariable("cod") String cod) {
		currencyService.edit(c);
	}

	@Override
	@DeleteMapping("/api/currency/{cod}")
	public void delete(@PathVariable("cod") String cod) {
		currencyService.delete(cod);
	}

	@Override
	@GetMapping("/api/currency/{cod}")
	public Currency findById(@PathVariable("cod") String cod) {
		return currencyService.findById(cod).get();
	}

	@Override
	@GetMapping("/api/currency/")
	public Iterable<Currency> findAll() {
		return currencyService.findAll();
	}

}
