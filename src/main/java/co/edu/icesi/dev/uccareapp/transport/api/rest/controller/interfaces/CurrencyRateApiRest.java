package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

public interface CurrencyRateApiRest {
	public void save(Currencyrate c);
	public void update(Currencyrate c, Integer id);
	public void delete(Integer id);
	public Currencyrate findById(Integer id);
	public Iterable<Currencyrate> findAll();

}
