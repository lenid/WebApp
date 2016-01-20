package gran.home.template.dao;

import gran.home.template.entity.Account;

public class AccountDao extends Dao<Account> {

	public AccountDao() {
		super(Account.class);
	}
	
	public Account getByLogin(String login) {
		return _getEntityByNamedQuery(Account.QUERY_FIND_LOGIN, login);
	}

}