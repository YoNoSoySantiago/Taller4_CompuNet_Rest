package co.edu.icesi.dev.uccareapp.transport.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.dev.uccareapp.transport.model.sales.Salesperson;

public interface SalesPersonRepository extends CrudRepository<Salesperson,Integer> {

}
