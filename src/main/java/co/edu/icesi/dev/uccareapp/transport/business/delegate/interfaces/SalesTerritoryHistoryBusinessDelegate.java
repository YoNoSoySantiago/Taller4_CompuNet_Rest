package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritoryhistory;

public interface SalesTerritoryHistoryBusinessDelegate {
	public void add(Salesterritoryhistory s);
	public void update(Salesterritoryhistory s);
	public void delete(Integer id);
	public Salesterritoryhistory findById(Integer id);
	public List<Salesterritoryhistory> findAll();
}
