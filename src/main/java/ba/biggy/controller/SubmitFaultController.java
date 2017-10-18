package ba.biggy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.global.Geocoding;
import ba.biggy.model.Fault;
import ba.biggy.model.geocoding.Location;



@Controller
public class SubmitFaultController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	
	@RequestMapping(value="/submitFault", method = RequestMethod.GET)
	public ModelAndView showSubmitFault(ModelAndView model) throws IOException{
	    Fault fault = new Fault();
	    model.addObject("fault", fault);
	    model.setViewName("submitFaultPage");
	    return model;
	}
	
	
	
	@RequestMapping(value = "/submitFault", method = RequestMethod.POST)
	public ModelAndView saveFault(@Valid @ModelAttribute Fault fault, 
			BindingResult result, ModelAndView model, HttpServletRequest request) {
		
		//Return same page if it has errors
		if (result.hasErrors()) {
			model.setViewName("submitFaultPage");
			return model;
		}
		
		//Otherwise get the address strings
		String street = request.getParameter("clientStreet");
		String postalCode = request.getParameter("clientPostalCode");
		String city = request.getParameter("clientPlace");
		
		//And receive lat and lng coordinates from Google
		Geocoding geocoding = new Geocoding();
		Location location = geocoding.getLatLng(street, postalCode, city);
		if (location != null) {
			double lat = location.getLat();
			double lng = location.getLng();
			fault.setFaultLat(lat);
			fault.setFaultLng(lng);
		}
		
		//Save the fault to MySQL
		faultDAO.saveOrUpdate(fault);
		
		model.setViewName("redirect:/faultsOverview");
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
