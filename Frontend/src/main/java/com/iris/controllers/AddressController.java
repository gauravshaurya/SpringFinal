package com.iris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.models.Address;

@Controller
public class AddressController {
	
	@RequestMapping(value="/getAddressForm",method=RequestMethod.GET)
	public String displayRegistrationForm(ModelMap map) {
		map.addAttribute("aObj", new Address());
		return "Address";
}
}
