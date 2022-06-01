package co.edu.icesi.dev.uccareapp.transport.dao.interfaces;

import java.util.Optional;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

public interface CurrencyRateDao {
	public void save(Currencyrate currencyRate);
	public void update(Currencyrate currencyRate);
	public void delete(Currencyrate currencyRate);
	public Optional<Currencyrate> findById(Integer currencyRateId);
	public Iterable<Currencyrate> findAll();
	public void deleteAll();
}
