package co.edu.icesi.dev.uccareapp.transport.dao.implementation;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.dev.uccareapp.transport.dao.interfaces.CurrencyRateDao;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;

@Repository
@Scope("singleton")
public class CurrencyRateDaoImp implements CurrencyRateDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CurrencyRateDaoImp(EntityManager em) {
		this.entityManager = em;
	}
	
	@Transactional
	@Override
	public void save(Currencyrate currencyRate) {
		entityManager.persist(currencyRate);
	}

	@Override
	public void update(Currencyrate currencyRate) {
		entityManager.merge(currencyRate);
	}

	@Override
	public void delete(Currencyrate currencyRate) {
		entityManager.remove(currencyRate);
	}

	@Override
	public Optional<Currencyrate> findById(Integer currencyRateId) {
		Currencyrate entity = entityManager.find(Currencyrate.class, currencyRateId);
		if(entity==null) return Optional.empty();
		return Optional.of(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Currencyrate> findAll() {
		String jpql = "SELECT c FROM Currencyrate c";
		return 	entityManager.createQuery(jpql).getResultList();	
	}

	@Override
	public void deleteAll() {
		String jpql = "DELETE FROM Currencyrate";
		entityManager.createQuery(jpql).executeUpdate();
	}

}
