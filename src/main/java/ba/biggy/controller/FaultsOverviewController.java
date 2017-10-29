package ba.biggy.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ba.biggy.dao.FaultDAO;
import ba.biggy.dao.ProductDAO;
import ba.biggy.dao.UserInfoDAO;
import ba.biggy.model.Fault;
import ba.biggy.model.Product;
import ba.biggy.model.UserInfo;
import ba.biggy.model.geocoding.Location;

@Controller
public class FaultsOverviewController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@RequestMapping (value = "/container/faultsOverview")
	public ModelAndView showToDoFaults (ModelAndView model) {
				
		/*
		 * Get a list of to do faults from MySQL table
		 */
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		
		/*
		 * Get a count of to do faults
		 */
		int faultCount = faultDAO.toDoFaultCount();
		model.addObject("faultCount", faultCount);
		
		model.setViewName("/container/faultsOverviewContainer");
		return model;
	}
	
	
	@RequestMapping(value = "/editFault", method = RequestMethod.GET)
	public ModelAndView editFault(ModelAndView model, HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		Fault fault = faultDAO.getFaultById(faultId);
		model.addObject("fault", fault);
		model.setViewName("admin/adminEditFault");
		return model;
	}
	
	
	
	@RequestMapping(value = "/editFault", method = RequestMethod.POST)
	public ModelAndView updateFault(@Valid @ModelAttribute Fault fault, 
			BindingResult result, ModelAndView model) {
		
		if (result.hasErrors()) {
			model.setViewName("admin/adminEditFault");
			return model;
		}
		
		faultDAO.saveOrUpdate(fault);
		model.setViewName("redirect:/container/faultsOverview");
	    return model;
	}
	
	
	@RequestMapping(value = "/archiveFault")
	public ModelAndView archiveFault (HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		faultDAO.archiveFault(faultId);
		return new ModelAndView ("redirect:/user/faultsOverview");
	}
	
	
	@RequestMapping(value = "/deleteFault")
	public ModelAndView deleteFault(HttpServletRequest request) {
	    int faultId = Integer.parseInt(request.getParameter("id"));
	    faultDAO.deleteFault(faultId);
	    return new ModelAndView("redirect:/container/faultsOverview");
	}
	
	
	@RequestMapping (value = "/user/faultsOverviewMap")
	public ModelAndView showToDoFaultsOnMap (ModelAndView model) throws JsonProcessingException {
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		
		ObjectMapper objectMapper = new ObjectMapper();
		model.addObject("faultList", objectMapper.writeValueAsString(toDoFaults));
		
		model.setViewName("/user/mapFaultsOverviewPage");
		return model;
	}
	
	
	
	@RequestMapping(value = "/viewFaultDetails", method = RequestMethod.GET)
	public ModelAndView viewFaultDetails(HttpServletRequest request, ModelAndView model) throws JsonProcessingException {
		int faultId = Integer.parseInt(request.getParameter("id"));
		Fault fault = faultDAO.getFaultById(faultId);
		ObjectMapper objectMapper = new ObjectMapper();
		model.addObject("faultDetails", objectMapper.writeValueAsString(fault));
		
		model.setViewName("/user/faultDetailsMapPage");
		return model;
	}
	
	
	
	
	@ModelAttribute("servicemanList")
	public Map<String, String> getServicemanList(){
	    Map<String, String> servicemanList = new HashMap<String, String>();
	    List<UserInfo> allServiceman = userInfoDAO.getAllServiceman();
	    for (UserInfo userInfo : allServiceman) {
	    	servicemanList.put(userInfo.getUsersName(), userInfo.getUsersName());
	    }
	    return servicemanList;
	}
	
	@ModelAttribute("adminList")
	public Map<String, String> getAdminList(){
		Map<String, String> adminList = new HashMap<String, String>();
		List<UserInfo> allAdmins = userInfoDAO.getAllAdmins();
		for (UserInfo userInfo : allAdmins) {
			adminList.put(userInfo.getUsersName(), userInfo.getUsersName());
		}
		return adminList;
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("usersList")
	public Map<String, String> getUsersList(){
	    Map<String, String> usersList = new HashMap<String, String>();
	    usersList.put("User 1", "User 1");
	    usersList.put("User 2", "User 2");
	    return usersList;
	}
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("typeOfServiceList")
	public Map<String, String> getTypeOfServiceList(){
	    Map<String, String> typeOfServiceList = new HashMap<String, String>();
	    typeOfServiceList.put("Urgent", "Urgent");
	    typeOfServiceList.put("Not urgent", "Not urgent");
	    return typeOfServiceList;
	}
	
	
	
	@ModelAttribute("productTypeList")
	public Map<String, String> getProductTypeList(){
	    Map<String, String> productTypeList = new HashMap<String, String>();
	    List<Product> productList = productDAO.getAllProducts();
	    for (Product product : productList) {
	    	productTypeList.put(product.getProductId(), product.getProductId());
	    }
	    return productTypeList;
	}

}
