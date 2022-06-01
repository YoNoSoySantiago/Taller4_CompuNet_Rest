package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.SalesTerritoryHistoryBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritoryhistory;

@Component
public class SalesTerritoryHistoryBusinessDelegateImp implements SalesTerritoryHistoryBusinessDelegate {

	private String url = "http://localhost:8080/api/sales_territory_history/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Salesterritoryhistory s) {
		restTemplate.postForObject(url, s, Salesterritoryhistory.class);
	}

	@Override
	public void update(Salesterritoryhistory s) {
		restTemplate.put(url + s.getId(), s);
	}

	@Override
	public void delete(Integer id) {
		restTemplate.delete(url + id, Integer.class);
	}

	@Override
	public Salesterritoryhistory findById(Integer id) {
		return restTemplate.getForObject(url + id, Salesterritoryhistory.class);
	}

	@Override
	public List<Salesterritoryhistory> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Salesterritoryhistory[].class));
	}

}
