package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesterritoryhistory;

public interface SalesTerritoryHistoryApiRest {
	public void save(Salesterritoryhistory s) throws InvalidValueException, ObjectDoesNotExistException, ObjectAlreadyExistException;
	public void update(Salesterritoryhistory s, Integer id) throws InvalidValueException, ObjectDoesNotExistException;
	public void delete(Integer id);
	public Salesterritoryhistory findById(Integer id);
	public Iterable<Salesterritoryhistory> findAll();
}
