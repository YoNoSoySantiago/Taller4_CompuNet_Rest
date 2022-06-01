package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritory;

public interface SalesTerritoryBusinessDelegate {
	public void add(Salesterritory s);
	public void update(Salesterritory s);
	public void delete(Integer id);
	public Salesterritory findById(Integer id);
	public List<Salesterritory> findAll();
}
