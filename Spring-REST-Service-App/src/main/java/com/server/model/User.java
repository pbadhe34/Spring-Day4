package com.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AppUser")
public class User {
 private String name;
 private int num;
 public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public double getIncome() {
	return income;
}
public void setIncome(double income) {
	this.income = income;
}
private double income;
 
}
