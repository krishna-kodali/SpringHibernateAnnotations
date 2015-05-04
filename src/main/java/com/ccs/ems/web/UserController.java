package com.ccs.ems.web;

import java.io.IOException;
import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*import src.main.java.com.ccs.ems.web.HttpServletRequest;
import src.main.java.com.ccs.ems.web.HttpServletResponse;
import src.main.java.com.ccs.ems.web.IOException;
import src.main.java.com.ccs.ems.web.ServletException;*/

import com.ccs.ems.model.User;
import com.ccs.ems.svc.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController{
	
	String message = "Welcome to Spring MVC!";
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="usersList", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("in UserController");
		
		/*ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);*/
		
		ModelAndView mv = new ModelAndView("UserList");
		mv.addObject("users", userService.getAllUsers());

		return mv;
	}
	
	@RequestMapping(value="userForm", method = RequestMethod.GET)
	public String showUserForm(ModelMap model)
	{
		User user = new User();
		model.addAttribute(user);
		return "userForm";
	}
	
	@RequestMapping(value="first", method = RequestMethod.GET)
	public ModelAndView showHomePage()
	{
		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Custom Login Form");
		//model.addObject("message", "This is welcome page!");
		model.setViewName("first");
		return model;
	}
	
	@RequestMapping(value="addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		//return "redirect:userSuccess.htm";
		return "userSuccess";
	}
	
	@RequestMapping(value="renameUserForm", method = RequestMethod.GET)
	public String showRenameUserForm(ModelMap model)
	{
		User user = new User();
		model.addAttribute(user);
		return "renameUserForm";
	}
	
	@RequestMapping(value="renameUser", method = RequestMethod.GET)
	public ModelAndView renameUser(@RequestParam String oldFirstName, @RequestParam String oldLastName, 
								@RequestParam String newFirstName, @RequestParam String newLastName) {
		userService.renameUser(oldFirstName, newFirstName, oldLastName, newLastName);
		//return "redirect:userSuccess.htm";
		return getAllUsers();
	}
	
	/*@RequestMapping(value="renameUser", method = RequestMethod.PUT)
	public String renameUser(HttpServletRequest req, HttpServletResponse resp) {
		//userService.renameUser(user.getUserFirstName(), newFirstName, oldLastName, newLastName)
		//return "redirect:userSuccess.htm";
		
		String oldFirstName = req.getParameter("oldFirstName");
		String oldLastName = req.getParameter("oldLastName");
		String newFirstName = req.getParameter("newFirstName");
		String newLastName = req.getParameter("newLastName");
		userService.renameUser(oldFirstName, newFirstName, oldLastName, newLastName);
		return "userList";
	}*/
	
}
