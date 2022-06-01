package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

public interface CurrencyApiRest {
	public void save(Currency c);
	public void update(Currency c, String cod);
	public void delete(String cod);
	public Currency findById(String cod);
	public Iterable<Currency> findAll();

}
