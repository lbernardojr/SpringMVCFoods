package com.mySpringWebApp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mySpringWebApp.model.FoodDAO;
import com.mySpringWebApp.model.Foods;

@SpringBootApplication
public class MyDriver {

	
	public static void main(String[] args) {
		
		SpringApplication.run(MyDriver.class, args);
		
		final Logger log = LoggerFactory.getLogger(MyDriver.class);
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");

		log.info("getting the Bean");
		FoodDAO myFoodDAO = appContext.getBean("foodsDAO", FoodDAO.class);
		
		List<Foods> myFoodsList = myFoodDAO.getFoods();
		
		log.info("Printing the Foods List");
		for(Foods fg: myFoodsList ) {
			System.out.println("ID: "+fg.getId() +" Name: "+ fg.getName() +" Description: "+ fg.getDescription());
		}

		log.info("Done printing the bean");
		((FileSystemXmlApplicationContext) appContext).close();
		log.info("Closing the application context");
	}
	
}
