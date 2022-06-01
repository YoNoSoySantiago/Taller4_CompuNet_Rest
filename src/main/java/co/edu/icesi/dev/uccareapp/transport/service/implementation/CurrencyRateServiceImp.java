package co.edu.icesi.dev.uccareapp.transport.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.uccareapp.transport.dao.interfaces.CurrencyRateDao;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;
import co.edu.icesi.dev.uccareapp.transport.service.interfaces.CurrencyRateService;

@Service
@Transactional
public class CurrencyRateServiceImp implements CurrencyRateService {

	private CurrencyRateDao currencyRateDao;
	
	@Autowired
	public CurrencyRateServiceImp(CurrencyRateDao currencyRateDao) {
		this.currencyRateDao = currencyRateDao;
	}
	
	@Override
	public void add(Currencyrate currencyRate) {
		this.currencyRateDao.save(currencyRate);
	}

	@Override
	public void edit(Currencyrate currencyRate) {
		this.currencyRateDao.update(currencyRate);
	}

	@Override
	public void delete(Integer id) {
		this.currencyRateDao.delete(findById(id).get());
	}

	@Override
	public Optional<Currencyrate> findById(Integer id) {
		return this.currencyRateDao.findById(id);
	}

	@Override
	public Iterable<Currencyrate> findAll() {
		return this.currencyRateDao.findAll();
	}

	@Override
	public void clear() {
		this.currencyRateDao.deleteAll();
	}

}
