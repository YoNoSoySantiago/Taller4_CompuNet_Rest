package co.edu.icesi.dev.uccareapp.transport.business.delegate.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.SalesPersonQuotaHistoryBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salespersonquotahistory;

@Component
public class SalesPersonQuotaHistoryBusinessDelegateImp implements SalesPersonQuotaHistoryBusinessDelegate {

	private String url = "http://localhost:8080/api/sales_person_quota_history/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void add(Salespersonquotahistory s) {
		restTemplate.postForObject(url, s, Salespersonquotahistory.class);
	}

	@Override
	public void update(Salespersonquotahistory s) {
		restTemplate.put(url + s.getId(), s);
	}

	@Override
	public void delete(Integer id) {
		restTemplate.delete(url + id, Integer.class);
	}

	@Override
	public Salespersonquotahistory findById(Integer id) {
		return restTemplate.getForObject(url + id, Salespersonquotahistory.class);
	}

	@Override
	public List<Salespersonquotahistory> findAll() {
		return Arrays.asList(restTemplate.getForObject(url, Salespersonquotahistory[].class));
	}

}
