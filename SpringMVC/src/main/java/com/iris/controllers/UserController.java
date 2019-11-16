package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/viewAllUsers", method=RequestMethod.GET)
	public ModelAndView getAllUsers() {
		
		List<User> users=userDao.getAllUsers();
		
		ModelAndView mv=new ModelAndView("ViewAllUsers");
		mv.addObject("uList", users);
		return mv;
	}
	
	@RequestMapping(value="/deleteUser/{userId}",method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int userId) {
		User uObj=userDao.getUserById(userId);
		
		userDao.deleteUser(uObj);
		
		ModelAndView mv=new ModelAndView("ViewAllUsers");
		mv.addObject("uList",userDao.getAllUsers());
		mv.addObject("msg", "User Successfully Deleted.");
		
		return mv;
	}
	
	@RequestMapping(value="/updateUser/{userId}",method=RequestMethod.GET)
	public ModelAndView getUpdateUserForm(@PathVariable int userId) {
		
		User uObj=userDao.getUserById(userId);
		
		ModelAndView mv=new ModelAndView("RegistrationForm");
		mv.addObject("uObj", "uObj");
		mv.addObject("buttoLabel", "Update");
		mv.addObject("formLabel", "Update Form");
		
		return mv;
	}
	
	

}
