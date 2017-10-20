package ba.biggy.controller;

import java.io.IOException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		model.setViewName("checkTomcat");
	
		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        Fault fault = new Fault();
        model.put("fault", fault);
        return "testPage";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("fault") Fault fault,
            BindingResult result, Map<String, Object> model) {
 
    	
        if (result.hasErrors()) {
            return "testPage";
        }
 
        return "submitFaultPage";
    }
	
	

}
