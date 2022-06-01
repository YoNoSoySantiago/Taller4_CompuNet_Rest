package co.edu.icesi.dev.uccareapp.transport.service.interfaces;

import java.util.Optional;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

public interface CurrencyService {
	
	public void add(Currency currency);
	public void edit(Currency currency);
	public void delete(String currency);
	
	public Optional<Currency> findById(String id);
	public Iterable<Currency> findAll();
	
	public void clear();

}
