package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

public interface CurrencyBusinessDelegate {
	public void add(Currency c);
	public void update(Currency c);
	public void delete(String cod);
	public Currency findById(String cod);
	public List<Currency> findAll();
}
