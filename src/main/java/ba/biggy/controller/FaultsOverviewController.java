package ba.biggy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.model.Fault;

@Controller
public class FaultsOverviewController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@RequestMapping (value = "/faultsOverview")
	public ModelAndView showToDoFaults (ModelAndView model) {
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		model.setViewName("faultsOverviewPage");
		return model;
	}
	
	
	@RequestMapping(value = "/editFault")
	public ModelAndView editFault(HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		Fault fault = faultDAO.getFaultById(faultId);
		ModelAndView model = new ModelAndView("editFaultPage");
		model.addObject("fault", fault);
		return model;
	}
	
	
	/*@RequestMapping(value = "/archiveFault", method = RequestMethod.GET)
	public ModelAndView archiveFault (HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		faultDAO.archiveFault(faultId);
		return new ModelAndView ("redirect:/faultsOverview");
	}*/
	
	
	/*@RequestMapping(value = "/deleteFault", method = RequestMethod.GET)
	public ModelAndView deleteFault(HttpServletRequest request) {
	    int faultId = Integer.parseInt(request.getParameter("id"));
	    faultDAO.delete(faultId);
	    return new ModelAndView("redirect:/faultsOverview");
	}*/

}
