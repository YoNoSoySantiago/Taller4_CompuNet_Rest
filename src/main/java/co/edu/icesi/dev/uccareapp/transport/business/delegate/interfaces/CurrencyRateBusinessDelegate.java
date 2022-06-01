package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

public interface CurrencyRateBusinessDelegate {
	public void add(Currencyrate c);
	public void update(Currencyrate c);
	public void delete(Integer id);
	public Currencyrate findById(Integer id);
	public List<Currencyrate> findAll();
}
