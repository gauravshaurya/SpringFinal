package com.iris.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Controller
public class IndexController {
	
		@Autowired
		UserDao userDao;
		
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String indexPage(ModelMap map) {
			map.addAttribute("myIndex", "Welcome to Spring MVC");
			
			return "IndexPage";
		}
		
		
		@RequestMapping(value="/getRegistrationForm",method=RequestMethod.GET)
		public String displayRegistrationForm(ModelMap map) {
			map.addAttribute("uObj", new User());
			map.addAttribute("buttonLabel", "Register");
			map.addAttribute("formLabel", "Registration Form");
			
			return "RegistrationForm";
		}
		
		@RequestMapping(value="/registerUser",method=RequestMethod.POST)
		public ModelAndView registerUser(@Valid @ModelAttribute("uObj")  User uObj,
				BindingResult result){
			
			if(result.hasErrors()){
				ModelAndView mv=new ModelAndView("LoginPage");
				//mv.addObject("userObj",new User());
				mv.addObject("buttonLabel","Register");
				mv.addObject("formLabel", "Registration Form");
				return mv;
			}
			else {
			userDao.registerUser(uObj);
			
			ModelAndView mv=new ModelAndView("LoginPage");
			mv.addObject("msg","User has been registered succesfully. Now u can Login");
			return mv;
			}
		}
		
		@RequestMapping(value="/getLoginPage",method=RequestMethod.GET)
		public String displayLoginPage(ModelMap map) {
			map.addAttribute("userObj", new User());
			return "LoginPage";
		}
		
		@Autowired
		HttpSession session;
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String loginUser(@RequestParam int userId,@RequestParam String password) {
			User uObj=userDao.loginUser(userId,password);
			System.out.println("User Obj : "+uObj);
			if(uObj!=null){
				
				session.setAttribute("uObj",uObj);
				
				if(uObj.getRole().equals("Admin")){
					return "AdminWelcome";
				}
				else {
					return "UserWelcome";
				}
				}
			else {
				return "LoginPage";
		}
		}
		
		@RequestMapping(value="/viewProfile",method=RequestMethod.GET)
		public String displayUser() {
			return "ViewProfile";
		}
		
}