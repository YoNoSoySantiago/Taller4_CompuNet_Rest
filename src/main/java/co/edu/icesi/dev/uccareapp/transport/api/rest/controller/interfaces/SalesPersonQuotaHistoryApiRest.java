package co.edu.icesi.dev.uccareapp.transport.api.rest.controller.interfaces;

import co.edu.icesi.dev.uccareapp.transport.customexeptions.InvalidValueException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectAlreadyExistException;
import co.edu.icesi.dev.uccareapp.transport.customexeptions.ObjectDoesNotExistException;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salespersonquotahistory;

public interface SalesPersonQuotaHistoryApiRest {
	public void save(Salespersonquotahistory s) throws InvalidValueException, ObjectAlreadyExistException, ObjectDoesNotExistException;
	public void update(Salespersonquotahistory s, Integer id) throws InvalidValueException, ObjectDoesNotExistException;
	public void delete(Integer id);
	public Salespersonquotahistory findById(Integer id);
	public Iterable<Salespersonquotahistory> findAll();

}
