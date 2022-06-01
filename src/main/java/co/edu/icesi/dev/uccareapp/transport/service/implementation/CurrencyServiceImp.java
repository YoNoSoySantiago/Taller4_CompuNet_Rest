package co.edu.icesi.dev.uccareapp.transport.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.uccareapp.transport.dao.interfaces.CurrencyDao;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.CurrencyService;

@Service
@Transactional
public class CurrencyServiceImp implements CurrencyService {

	
	private CurrencyDao currencyDao;
	
	@Autowired
	public CurrencyServiceImp(CurrencyDao currencyDao) {
		this.currencyDao = currencyDao;
	}
	
	@Override
	public void add(Currency currency) {
		this.currencyDao.save(currency);
	}

	@Override
	public void edit(Currency currency) {
		this.currencyDao.update(currency);;
	}

	@Override
	public void delete(String id) {
		this.currencyDao.delete(findById(id).get());
	}

	@Override
	public Optional<Currency> findById(String cod) {
		return this.currencyDao.findById(cod);
	}

	@Override
	public Iterable<Currency> findAll() {
		return this.currencyDao.findAll();
	}

	@Override
	public void clear() {
		this.currencyDao.deleteAll();
	}

}
