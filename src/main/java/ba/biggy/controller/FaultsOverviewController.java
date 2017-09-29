package ba.biggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
