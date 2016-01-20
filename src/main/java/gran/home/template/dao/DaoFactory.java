package gran.home.template.dao;

import java.lang.reflect.Constructor;
import java.sql.SQLException;

import gran.home.template.entity.BaseEntity;

public class DaoFactory {

	public static Dao<? extends BaseEntity> createEntity(Class<? extends Dao<? extends BaseEntity>> classDao)
			throws SQLException {
		try {
			Constructor<? extends Dao<? extends BaseEntity>> constructor = classDao.getConstructor();
			return (Dao<? extends BaseEntity>) constructor.newInstance();
		} catch (Exception e) {
			throw new SQLException("Can't instantiate DAO class: " + classDao.getName());
		}
	}
	
	public static AccountDao getAccountDao() throws SQLException {
		return (AccountDao) createEntity(AccountDao.class);
	}

}
