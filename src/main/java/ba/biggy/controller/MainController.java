package ba.biggy.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.model.Fault;
import ba.biggy.model.UserInfo;




@Controller
public class MainController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@RequestMapping(value="/")
	public ModelAndView showHomescreen(ModelAndView model) throws IOException{
		//TODO handle redirect based on user_role
		return new ModelAndView("redirect:/container/faultsOverview");
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin (ModelAndView model) {
		UserInfo user = new UserInfo();
		model.addObject("user", user);
		
		model.setViewName("loginPage");
		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	   public ModelAndView accessDenied(ModelAndView model, Principal principal) {
	        
			model.setViewName("403Page");
	       
	       return model;
	   }
	
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("fault") Fault fault,
            BindingResult result, Map<String, Object> model) {
 
    	
        if (result.hasErrors()) {
            return "loginPage";
        }
 
        return "submitFaultPage";
    }*/
	
	
	
	
	
	
	
	
	
	
	@RequestMapping (value = "/test")
	public ModelAndView showTest (ModelAndView model) throws IOException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      model.addObject("msg", name); 
		model.addObject("role", name);
		
		
		List<Fault> toDoFaults = faultDAO.listToDoFaults();
		model.addObject("toDoFaults", toDoFaults);
		
		
		
		model.setViewName("/container/faultsOverviewContainer");
	
		return model;
	}
	
	
    
    @RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	   public String welcomePage(Model model) {
	       model.addAttribute("title", "Welcome");
	       model.addAttribute("message", "This is welcome page!");
	       return "testPage";
	   }
	
	

}
