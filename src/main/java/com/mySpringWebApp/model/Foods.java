package com.mySpringWebApp.model;

public class Foods {

	private int id;
	private String name;
	private String description;

	public Foods() {
		/* No args constructor */
	}

	public Foods(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String talk() {
		return "Food group name: " + name + "\nFood description: " + description + "\nID: " + id;

	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", description=" + description;
	}

}
