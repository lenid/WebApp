package gran.home.template.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import gran.home.template.entity.BaseEntity;
import gran.home.template.util.PropertyLoader;

public abstract class Dao<E extends BaseEntity> {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
	protected static EntityManager entityManager;
	private final Class<E> entityClass;

	public Dao(Class<E> clazz) {
		this.entityClass = clazz;
	}

	static {
		try {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(PropertyLoader.getDbName());
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void stop() {
		ENTITY_MANAGER_FACTORY.close();
	}

	public void create(E entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		EntityManager entityMan = getEntityManager();
		Session session = entityMan.unwrap(Session.class);
		List<E> entities = session.createCriteria(entityClass).list();
		return entities;
	}

	public E getById(int id) {
		EntityManager entityManager = getEntityManager();
		return (E) entityManager.find(entityClass, id);
	}

	public void update(E entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public void delete(E entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(entity));
		entityManager.getTransaction().commit();
	}

	public void delete(int id) {
		delete(getById(id));
	}

	public EntityManager getEntityManager() {
		// if (entityManager == null) {
		entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		// }
		// if (!entityManager.isOpen()) {
		// System.out.println("Error!!!!!! entityManager is closed");
		// }

		if (!ENTITY_MANAGER_FACTORY.isOpen()) {
			System.out.println("ENTITY_MANAGER_FACTORY is closed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	protected E _getEntityByNamedQuery(String queryName, Object... paramValues) {
		Query query = _findByNamedQuery(queryName, paramValues);
		try {
			return (E) query.getSingleResult();
		} catch (NoResultException nre) {
			nre.printStackTrace(); // will be deleted
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	protected List<E> _getListByNamedQuery(String queryName, Object... paramValues) {
		Query query = _findByNamedQuery(queryName, paramValues);
		if (query == null) {
			return null;
		}
		return (List<E>) query.getResultList();
	}

	private Query _findByNamedQuery(String queryName, Object... paramValues) {
		Query query = getEntityManager().createNamedQuery(queryName);
		if (paramValues != null) {
			for (int i = 0; i < paramValues.length; i++) {
				query.setParameter(i + 1, paramValues[i]);
			}
		}
		return query;
	}

}
