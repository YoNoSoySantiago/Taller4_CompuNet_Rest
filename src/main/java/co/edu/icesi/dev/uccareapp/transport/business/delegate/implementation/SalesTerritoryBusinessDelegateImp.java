package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.SalesTerritoryBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritory;

@Component
public class SalesTerritoryBusinessDelegateImp implements SalesTerritoryBusinessDelegate {

	private String url = "http://localhost:8080/api/sales_territory/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Salesterritory s) {
		restTemplate.postForObject(url, s, Salesterritory.class);
	}

	@Override
	public void update(Salesterritory s) {
		restTemplate.put(url + s.getTerritoryid(), s);
	}

	@Override
	public void delete(Integer id) {
		restTemplate.delete(url + id, Integer.class);
	}

	@Override
	public Salesterritory findById(Integer id) {
		return restTemplate.getForObject(url + id, Salesterritory.class);
	}

	@Override
	public List<Salesterritory> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Salesterritory[].class));
	}

}
