package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.CurrencyBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

@Component
public class CurrencyBusinessDelegateImp implements CurrencyBusinessDelegate {

	private String url = "http://localhost:8080/api/currency/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Currency c) {
		restTemplate.postForObject(url, c, Currency.class);
	}

	@Override
	public void update(Currency c) {
		restTemplate.put(url + c.getCurrencycode(), c);
	}

	@Override
	public void delete(String cod) {
		restTemplate.delete(url + cod, String.class);
	}

	@Override
	public Currency findById(String cod) {
		return restTemplate.getForObject(url + cod, Currency.class);
	}

	@Override
	public List<Currency> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Currency[].class));
	}

}
