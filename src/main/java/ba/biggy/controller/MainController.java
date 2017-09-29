package ba.biggy.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.model.Fault;




@Controller
public class MainController {
	
	
	
	@RequestMapping(value="/")
	public ModelAndView showHomescreen(ModelAndView model) throws IOException{
		
		return new ModelAndView("redirect:/submitFault");
	}
	
	
	@RequestMapping (value = "/test")
	public ModelAndView showTest (ModelAndView model) throws IOException{
		Fault fault = new Fault();
		model.addObject("fault", fault);
		model.setViewName("editFaultPage");
	
		return model;
	}
	
	
	
	
	

}
