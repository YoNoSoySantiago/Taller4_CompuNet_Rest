package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.CurrencyRateBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

@Component
public class CurrencyRateBusinessDelegateImp implements CurrencyRateBusinessDelegate {

	private String url = "http://localhost:8080/api/currency_rate/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Currencyrate c) {
		restTemplate.postForObject(url, c, Currencyrate.class);
	}

	@Override
	public void update(Currencyrate c) {
		restTemplate.put(url + c.getCurrencyrateid(), c);
	}

	@Override
	public void delete(Integer id) {
		restTemplate.delete(url + id, Integer.class);
	}

	@Override
	public Currencyrate findById(Integer id) {
		return restTemplate.getForObject(url + id, Currencyrate.class);
	}

	@Override
	public List<Currencyrate> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Currencyrate[].class));
	}

}
