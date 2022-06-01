package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesperson;

public interface SalesPersonApiRest {
	public void save(Salesperson s) throws InvalidValueException, ObjectAlreadyExistException, ObjectDoesNotExistException;
	public void update(Salesperson s, Integer id) throws InvalidValueException, ObjectDoesNotExistException;
	public void delete(Integer id);
	public Salesperson findById(Integer id);
	public Iterable<Salesperson> findAll();

}
