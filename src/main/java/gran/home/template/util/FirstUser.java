package gran.home.template.util;

import gran.home.template.dao.AccountDao;
import gran.home.template.dao.Dao;
import gran.home.template.entity.Account;
import gran.home.template.entity.Account.Type;

public class FirstUser {

	private static final String LOGIN = "admin";
	private static final String PASSWD = "$2a$10$2vdm9CyZKtGKFjYIY6wKaO0VKx/rVeLlzHE5DWUANna8x3i8.KtQW";

	public static void main(String[] args) {

		try {
			if (new FirstUser().createAccount()) {
				System.out.printf("User was created with login \"%s\" and password \"%s\"", LOGIN, "pass");
			} else {
				System.err.println("Creating first user has failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.stop();
		}

	}

	private boolean createAccount() throws Exception {
		AccountDao dao = new AccountDao();;

		Account oldAccount = dao.getByLogin(LOGIN);
		if (oldAccount != null) {
			dao.delete(oldAccount.getId());
		}

		Account account = getAccount();
		dao.create(account);

		if (dao.getByLogin(LOGIN) == null) {
			return false;
		}
		return true;
	}

	private Account getAccount() {
		Account account = new Account();

		account.setLogin(LOGIN);
		account.setHashPasswd(PASSWD);
		account.setType(Type.ADMIN);

		return account;
	}

}
