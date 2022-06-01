package co.edu.icesi.dev.uccareapp.transport.dao.interfaces;

import java.util.Optional;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

public interface CurrencyDao {
	public void save(Currency currency);
	public void update(Currency currency);
	public void delete(Currency currency);
	public Optional<Currency> findById(String coruntryCode);
	public Iterable<Currency> findAll();
	public void deleteAll();
}
