package com.example.antinapoles;

public class budgetinfo {
	String municipal_name,month,budget,description,total_expenses;

	public String getMunicipal_name() {
		return municipal_name;
	}

	public void setMunicipal_name(String municipal_name) {
		this.municipal_name = municipal_name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotal_expenses() {
		return total_expenses;
	}

	public void setTotal_expenses(String total_expenses) {
		this.total_expenses = total_expenses;
	}

	public budgetinfo(String municipal_name, String month, String budget,
			String description, String total_expenses) {
		super();
		this.municipal_name = municipal_name;
		this.month = month;
		this.budget = budget;
		this.description = description;
		this.total_expenses = total_expenses;
	}
	
}
