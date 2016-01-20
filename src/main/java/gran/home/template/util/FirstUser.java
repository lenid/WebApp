package gran.home.template.util;

import gran.home.template.dao.Dao;
import gran.home.template.dao.DaoFactory;
import gran.home.template.dao.AccountDao;
import gran.home.template.entity.Account;
import gran.home.template.entity.Account.Type;

public class FirstUser {

	private static final String LOGIN = "admin";
	private static final String PASSWD = "$2a$10$2vdm9CyZKtGKFjYIY6wKaO0VKx/rVeLlzHE5DWUANna8x3i8.KtQW";

	public static void main(String[] args) {

		try {
			if (new FirstUser().createUser()) {
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

	private boolean createUser() throws Exception {
		AccountDao dao = DaoFactory.getAccountDao();

		Account oldUser = dao.getByLogin(LOGIN);
		if (oldUser != null) {
			dao.delete(oldUser.getId());
		}

		Account user = getUser();
		dao.create(user);

		if (dao.getByLogin(LOGIN) == null) {
			return false;
		}
		return true;
	}

	private Account getUser() {
		Account user = new Account();

		user.setLogin(LOGIN);
		user.setHashPasswd(PASSWD);
		user.setType(Type.ADMIN);

		return user;
	}

}
