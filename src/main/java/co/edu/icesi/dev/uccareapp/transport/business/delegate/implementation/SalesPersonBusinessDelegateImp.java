package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.SalesPersonBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesperson;

@Component
public class SalesPersonBusinessDelegateImp implements SalesPersonBusinessDelegate {

	private String url = "http://localhost:8080/api/sales_person/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Salesperson s) {
		restTemplate.postForObject(url, s, Salesperson.class);
	}

	@Override
	public void update(Salesperson s) {
		restTemplate.put(url + s.getBusinessentityid(), s);
	}

	@Override
	public void delete(Integer id) {
		restTemplate.delete(url + id, Integer.class);
	}

	@Override
	public Salesperson findById(Integer id) {
		return restTemplate.getForObject(url + id, Salesperson.class);
	}

	@Override
	public List<Salesperson> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Salesperson[].class));
	}

}
