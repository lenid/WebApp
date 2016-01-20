//package gran.home.template.controllers;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
////import javax.ws.rs.WebApplicationException;
////import javax.ws.rs.core.Response.Status;
//
//import org.codehaus.plexus.util.StringUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import gran.home.template.dao.DaoFactory;
//import gran.home.template.data.MessageVo;
//import gran.home.template.entity.Account;
//
//@Controller
//public class UserController extends BaseController {
//
//	private static final String VALIDATION_USER_NAME_REGEXP = "^[a-z0-9_-]{3,15}$";
//
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//	public ModelAndView getAll(@ModelAttribute ArrayList<MessageVo> messages) {
//		List<Account> users = null;
//
//		try {
//			users = DaoFactory.getAccountDao().getAll();
//		} catch (SQLException e) {
////			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
//		}
//
//		initModel("users", messages);
//		addObject("userList", users);
//		return getModel();
//	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public ModelAndView get(@RequestParam("id") Integer id, @ModelAttribute ArrayList<MessageVo> messages, @ModelAttribute Account user) {
//		String headerMessage = null;
//
//		try {
//			if (id != null) {
//				user = DaoFactory.getAccountDao().getById(id);
//				user.setHashPasswd(null);
//				headerMessage = "Edit User";
//			} else {
//				// user = new User();
//				headerMessage = "Add User";
//			}
//		} catch (SQLException e) {
//			messages.add(new MessageVo(false, "Can't get user with id: " + id + "\n" + e.getMessage()));
//		}
//
//		initModel("user", messages);
//		
//		addObject("user", user);
//		addObject("headerMessage", headerMessage);
//
//		return getModel();
//	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String createOrEdit(@ModelAttribute("user") Account user, RedirectAttributes redirectAttributes) {
//		List<MessageVo> messages = new ArrayList<>();
//
//		try {
////			boolean setPasswd = (user.getId() == null || (user.getId() != null && StringUtils.isNotEmpty(user.getPasswd())));
//			
//			boolean valid = true;
//			if (DaoFactory.getAccountDao().getByLogin(user.getLogin()) != null) {
//				messages.add(new MessageVo(false, "Login already exists"));
//				valid = false;
//			}
//			
//			if (!isValidLogin(user.getLogin())) {
//				messages.add(new MessageVo(false, "Login is not valid"));
//				valid = false;
//			}
//			if (/*setPasswd && */!isValidPassword(user.getHashPasswd())) {
//				messages.add(new MessageVo(false, "Password is not valid"));
//				valid = false;
//			}
//
//			if (valid) {
//				
//				if (user.getId() == null) {
////					user.setCreated(new Date());
//					DaoFactory.getAccountDao().create(user);
//					messages.add(new MessageVo(true, "User added"));
//				} else {
//					DaoFactory.getAccountDao().update(user);
//					messages.add(new MessageVo(true, "User updated"));
//				}
//				
////				if (setPasswd) {
////					DaoFactory.getUserDao().updatePasswd(user);
////				}
//				
//				redirectAttributes.addFlashAttribute(messages);
//				return "redirect:/users";
//			}
//		} catch (SQLException e) {
//			messages.add(new MessageVo(false, "Can't save user: " + e.getMessage()));
//		}
//		redirectAttributes.addFlashAttribute(messages);
//		redirectAttributes.addFlashAttribute(user);
//		return "redirect:/user?id=" + (user.getId() == null ? "" : user.getId());
//	}
//
//	@RequestMapping(value = "/userdel", method = RequestMethod.GET)
//	public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
//		List<MessageVo> messages = new ArrayList<>();
//
//		try {
//			DaoFactory.getAccountDao().delete(id);
//			messages.add(new MessageVo(true, "User deleted"));
//		} catch (SQLException e) {
////			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
//		}
//
//		redirectAttributes.addFlashAttribute(messages);
//		return "redirect:/users";
//	}
//
//	private boolean isValidLogin(String login) {
//		if (login == null) {
//			return false;
//		}
//		Pattern pattern = Pattern.compile(VALIDATION_USER_NAME_REGEXP);
//		Matcher matcher = pattern.matcher(login);
//		return matcher.matches();
//	}
//
//	private boolean isValidPassword(String password) {
//		return StringUtils.isNotEmpty(password);
//	}
//}
