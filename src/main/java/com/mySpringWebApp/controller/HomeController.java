package com.mySpringWebApp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mySpringWebApp.model.FoodDAO;
import com.mySpringWebApp.model.Foods;

@Controller
@ComponentScan
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "homepage";
	}
	
	@RequestMapping(value = "/foodsList", method = RequestMethod.GET)
	public String foodsList (Model model) {
		
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		FoodDAO myFoodDAO = appContext.getBean("foodsDAO", FoodDAO.class);
		List<Foods> myFoodsList = myFoodDAO.getFoods();
		((FileSystemXmlApplicationContext) appContext).close();
		model.addAttribute("foodslist",myFoodsList);
		
		return "foodslist";
	}

}