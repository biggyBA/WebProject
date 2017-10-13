package ba.biggy.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.global.Constants;
import ba.biggy.global.Geocoding;
import ba.biggy.model.Fault;
import ba.biggy.model.geocoding.GeocodingResponse;
import ba.biggy.model.geocoding.Geometry;
import ba.biggy.model.geocoding.Location;
import ba.biggy.model.geocoding.Result;

@Controller
public class FaultsOverviewController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@RequestMapping (value = "/faultsOverview")
	public ModelAndView showToDoFaults (ModelAndView model) {
		/*
		 * Get a list of to do faults from MySQL table
		 */
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		
		
		
		Geocoding geocoding = new Geocoding();
		
		//String latString = String.valueOf(geocoding.getLat("Grapska", "grapska"));
		
		Location location = geocoding.getLatLng("Grapska", "grapska");
		//String latString = geocoding.getLat("Tuzla", "slavinovic");
		
		
		model.addObject("location", location);
		
		
		
		
		model.setViewName("faultsOverviewPage");
		return model;
	}
	
	
	@RequestMapping(value = "/editFault", method = RequestMethod.GET)
	public ModelAndView editFault(HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		Fault fault = faultDAO.getFaultById(faultId);
		ModelAndView model = new ModelAndView("editFaultPage");
		model.addObject("fault", fault);
		return model;
	}
	
	
	@RequestMapping(value = "/editFault", method = RequestMethod.POST)
	public ModelAndView updateFault(@Valid @ModelAttribute Fault fault, 
			BindingResult result, ModelAndView model) {
		
		if (result.hasErrors()) {
			model.setViewName("editFaultPage");
			return model;
		}
		
		faultDAO.saveOrUpdate(fault);
		model.setViewName("redirect:/faultsOverview");
	    return model;
	}
	
	
	@RequestMapping(value = "/archiveFault")
	public ModelAndView archiveFault (HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		faultDAO.archiveFault(faultId);
		return new ModelAndView ("redirect:/faultsOverview");
	}
	
	
	@RequestMapping(value = "/deleteFault")
	public ModelAndView deleteFault(HttpServletRequest request) {
	    int faultId = Integer.parseInt(request.getParameter("id"));
	    faultDAO.deleteFault(faultId);
	    return new ModelAndView("redirect:/faultsOverview");
	}
	
	
	@RequestMapping (value = "/faultsOverviewMap")
	public ModelAndView showToDoFaultsOnMap (ModelAndView model) {
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		model.setViewName("mapFaultsOverviewPage");
		return model;
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("servicemanList")
	public Map<String, String> getServicemanList(){
	    Map<String, String> servicemanList = new HashMap<String, String>();
	    servicemanList.put("Serviceman 1", "Serviceman 1");
	    servicemanList.put("Serviceman 2", "Serviceman 2");
	    servicemanList.put("Serviceman 3", "Serviceman 3");
	    servicemanList.put("Serviceman 4", "Serviceman 4");
	    servicemanList.put("Serviceman 5", "Serviceman 5");
	    return servicemanList;
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
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("productTypeList")
	public Map<String, String> getProductTypeList(){
	    Map<String, String> productTypeList = new HashMap<String, String>();
	    productTypeList.put("7.5 kW", "7.5 kW");
	    productTypeList.put("11 kW", "11 kW");
	    productTypeList.put("10.5 kW", "10.5 kW");
	    productTypeList.put("20 kW", "20 kW");
	    productTypeList.put("35 kW", "35 kW");
	    productTypeList.put("50 kW", "50 kW");
	    productTypeList.put("75 kW", "75 kW");
	    productTypeList.put("100 kW", "100 kW");
	    return productTypeList;
	}

}
