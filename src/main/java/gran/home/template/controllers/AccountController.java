package gran.home.template.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gran.home.template.dao.DaoFactory;
import gran.home.template.dao.AccountDao;
import gran.home.template.data.MessageVo;
import gran.home.template.entity.Account;
import gran.home.template.entity.Account.Type;
import gran.home.template.util.SecurityHelper;

@Controller
public class AccountController extends BaseController {

	@Autowired
	RequestCache requestCache;

	@Autowired
	@Qualifier("authenticationManager")
	protected AuthenticationManager authenticationManager;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) Boolean isError, ModelMap model) {
		if (isError != null && isError) {
			model.addAttribute("error", "true");
			return "login";
		}
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignUpPage(HttpServletRequest request, HttpServletResponse response) {
		initModel("account");
		includeAccountData(false);
		includeNaviPanel(false);
		addObject("user", new Account());

		return getModel();
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("user") Account user, HttpServletRequest request, HttpServletResponse response) {
		user.setType(Type.USER);
		user.setHashPasswd(SecurityHelper.getHashPassword(user.getNewPasswd()));

		AccountDao dao = null;
		try {
			dao = DaoFactory.getAccountDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.create(user);

		authenticateUserAndSetSession(user, request);

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView getAccount(@ModelAttribute ArrayList<MessageVo> messages, HttpServletRequest request) {
		initModel("account", messages);
		try {
			addObject("user", SecurityHelper.getUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addObject("isNewAccount", false); // will be delete

		return getModel();
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String createOrEdit(@ModelAttribute("user") Account user, RedirectAttributes redirectAttributes) throws Exception {
		List<MessageVo> messages = new ArrayList<>();
		AccountDao userDao = null;

		try {
			userDao = DaoFactory.getAccountDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user.getId() == null) {
			// userDao.create(user);
		} else {
			if (checkPasswd(user)) {
				userDao.update(user);
				messages.add(new MessageVo(true, "Account updated"));
			} else {
				messages.add(new MessageVo(false, "You typed wrong old password!"));
			}

			if (!SecurityHelper.getUsername().equals(user.getLogin())) {
				SecurityContextHolder.getContext().setAuthentication(null);
			}
			redirectAttributes.addFlashAttribute(messages);
		}

		return "redirect:/account";
	}

	private boolean checkPasswd(Account user) throws SQLException {
		if (!user.getNewPasswd().equals("")) {
			if (SecurityHelper.checkPasswd(user.getOldPasswd())) {
				user.setHashPasswd(SecurityHelper.getHashPassword(user.getNewPasswd()));
			} else {
				return false;
			}
		}
		return true;
	}

	private void authenticateUserAndSetSession(Account user, HttpServletRequest request) {
		String username = user.getLogin();
		String password = user.getNewPasswd();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
	}

}
