package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritory;

public interface SalesTerritoryApiRest {
	public void save(Salesterritory s) throws InvalidValueException, ObjectDoesNotExistException;
	public void update(Salesterritory s, Integer id) throws InvalidValueException, ObjectDoesNotExistException;
	public void delete(Integer id);
	public Salesterritory findById(Integer id);
	public Iterable<Salesterritory> findAll();

}
