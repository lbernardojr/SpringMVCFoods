package com.mySpringWebApp.model;

import java.util.List;
import java.util.Map;

public class Fruit {

	private String fruitName;
	private List<String> fruitNameList;
	private Map<String,String> fruitNameMap;

	public Fruit() {
		// no argument constructor
	}

	public Fruit(String pName) {
		setFruitName(pName);
	}

	public String talk() {
		String speech = "Hello I'm a Fruit!";
		if(fruitName!=null && fruitName !="") speech += " My name is: " + fruitName;
		
		if(fruitNameList!=null && fruitNameList.size() > 0) {
			speech += "List: ";
			for(int i = 0; i < fruitNameList.size(); i++) {
				speech += "\nName: " + fruitNameList.get(i);
			}
		};
		
		if(fruitNameMap!=null && fruitNameMap.size() > 0) {
			speech += "\nMap: ";
			for(Map.Entry<String, String> fruitName: fruitNameMap.entrySet()) {
				speech += fruitName.getKey() + " ==> " + fruitName.getValue() + " :: ";
			}
		};
		
		return speech;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public List<String> getFruitNameList() {
		return fruitNameList;
	}

	public void setFruitNameList(List<String> fruitNameList) {
		this.fruitNameList = fruitNameList;
	}

	public Map<String, String> getFruitNameMap() {
		return fruitNameMap;
	}

	public void setFruitNameMap(Map<String, String> fruitNameMap) {
		this.fruitNameMap = fruitNameMap;
	}

}
