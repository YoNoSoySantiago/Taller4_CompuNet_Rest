package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Salespersonquotahistory;

public interface SalesPersonQuotaHistoryBusinessDelegate {
	public void add(Salespersonquotahistory s);
	public void update(Salespersonquotahistory s);
	public void delete(Integer id);
	public Salespersonquotahistory findById(Integer id);
	public List<Salespersonquotahistory> findAll();
}
