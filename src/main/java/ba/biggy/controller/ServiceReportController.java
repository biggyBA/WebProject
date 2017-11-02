package ba.biggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.dao.UserInfoDAO;
import ba.biggy.model.Fault;
import ba.biggy.model.ServiceReport;
import ba.biggy.model.UserInfo;

@Controller
public class ServiceReportController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	
	@RequestMapping (value = "/serviceman/myServices", method = RequestMethod.GET)
	public ModelAndView getMyServices (ModelAndView model) {
		
		
		model.setViewName("/serviceman/servicemanMyServices");
		return model;
	}
	
	
	@RequestMapping (value = "/serviceman/serviceReport", method = RequestMethod.GET)
	public ModelAndView showServiceReport (ModelAndView model) {
		ServiceReport serviceReport = new ServiceReport();
		model.addObject("serviceReport", serviceReport);
		model.setViewName("/serviceman/servicemanServiceReport");
		return model;
	}

	
}
