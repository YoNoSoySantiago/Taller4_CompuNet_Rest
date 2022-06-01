package co.edu.icesi.dev.uccareapp.transport.dao.implementation;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.dev.uccareapp.transport.dao.interfaces.CurrencyDao;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

@Repository
@Scope("singleton")
public class CurrencyDaoImp implements CurrencyDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CurrencyDaoImp(EntityManager em) {
		this.entityManager = em;
	}
	
	@Transactional
	@Override
	public void save(Currency currency) {
		entityManager.persist(currency);
	}

	@Override
	public void update(Currency currency) {
		entityManager.merge(currency);
	}

	@Override
	public void delete(Currency currency) {
		entityManager.remove(currency);
	}

	@Override
	public Optional<Currency> findById(String currencyCode) {
		Currency entity = entityManager.find(Currency.class, currencyCode);
		if(entity==null) return Optional.empty();
		return Optional.of(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Currency> findAll() {
		String jpql = "SELECT c FROM Currencyrate c";
		return 	entityManager.createQuery(jpql).getResultList();	
	}

	@Override
	public void deleteAll() {
		String jpql = "DELETE FROM Currency";
		entityManager.createQuery(jpql).executeUpdate();
	}

}
