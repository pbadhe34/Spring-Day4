package com.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

 
//This program  using Spring4.1 with Hibernate 4.1 and jackson ver2.1 libraries

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation *  
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="PersonDataTable")
public class Person implements java.io.Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@JsonProperty("id")
	private int id;
	
	//@JsonProperty("name")
	private String name;
	
	//@JsonProperty("country")
	private String country;

	//@JsonProperty("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/*@Override
	public String toString(){
		return "id="+getId()+", name="+getName()+", country="+getCountry();
	}*/
}
