package co.edu.icesi.dev.uccareapp.transport.service.interfaces;

import java.util.Optional;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

public interface CurrencyRateService {
	
	public void add(Currencyrate currencyRate);
	public void edit(Currencyrate currencyRate);
	public void delete(Integer id);
	
	public Optional<Currencyrate> findById(Integer id);
	public Iterable<Currencyrate> findAll();
	
	public void clear();

}
