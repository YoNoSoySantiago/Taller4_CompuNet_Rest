package co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces;

import java.util.List;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesperson;

public interface SalesPersonBusinessDelegate {
	public void add(Salesperson s);
	public void update(Salesperson s);
	public void delete(Integer id);
	public Salesperson findById(Integer id);
	public List<Salesperson> findAll();
}
