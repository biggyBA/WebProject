package ba.biggy.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
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
	
	
	
	
	
	
	
	
	
	
	@RequestMapping (value = "/test", method = RequestMethod.GET)
	public ModelAndView showTest (ModelAndView model, Authentication authentication) throws IOException{
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      //String name = auth.getName();
	      //model.addObject("msg", name); 
		//model.addObject("role", name);
		
		/*UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("User has authorities: " + userDetails.getAuthorities());*/
		//UserAuthentication userAuth = new UserAuthentication();
		/*if (hasRole("ROLE_USER")) {
			String ad = "hasRoleAdmin";
			model.addObject("str", ad);
		}else {
			String ad = "hasNotRoleAdmin";
			model.addObject("str", ad);
		}
		Fault fault = new Fault();
		model.addObject("fault", fault);*/
		
		
		List<Fault> faults = faultDAO.listToDoFaults();
		model.addObject("faults", faults);
		
		model.setViewName("pdfView");
	
		return model;
	}
	
	
    
    @RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	   public ModelAndView welcomePage(ModelAndView model) {
    	List<Fault> faults = faultDAO.listToDoFaults();
		model.addObject("faulty", faults);
		
		model.setViewName("testPage");
	       return model;
	   }
	
    
    private boolean hasRole(String role) {
		  @SuppressWarnings("unchecked")
		  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		}

}
