package gran.home.template.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import gran.home.template.data.MessageVo;
import gran.home.template.util.SecurityHelper;

public abstract class BaseController {

	private ModelAndView model;
	private List<MessageVo> messages;
	private boolean includeNaviPanel;
	private boolean includeAccountData;
	
	protected ModelAndView initModel(String viewName) {
		model = new ModelAndView(viewName);
		includeNaviPanel = true;
		includeAccountData = true;

		messages = new ArrayList<>();
		model.addObject("messages", messages);
		
		return model;
	}
	
	protected ModelAndView initModel(String viewName, ArrayList<MessageVo> messages) {
		ModelAndView model = initModel(viewName);
		this.messages.addAll(messages);
		return model;
	}
	
	protected ModelAndView getModel() {
		initHeader();
		initNaviPanel();
		
		return model;
	}
	
	protected void addObject(String attributeName, Object attributeValue) {
		model.addObject(attributeName, attributeValue);
	}
	
	protected void addMessage(boolean type, String message) {
		messages.add(new MessageVo(type, message));
	}
	
	protected void includeAccountData(boolean includeAccountData) {
		this.includeAccountData = includeAccountData;
	}
	
	protected void includeNaviPanel(boolean includeNaviPanel) {
		this.includeNaviPanel = includeNaviPanel;
	}
	
	private void initHeader() {
		model.addObject("includeAccountData", includeAccountData);
		
		if (includeAccountData) {
			addObject("userName", SecurityHelper.getUsername());
		}
	}
	
	private void initNaviPanel() {
		model.addObject("includeNaviPanel", includeNaviPanel);
		
		if (includeNaviPanel) {
			addObject("includeNaviPanel", includeNaviPanel);
		}
	}
	
}
