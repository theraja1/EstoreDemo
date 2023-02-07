package com.wipro.bankofamerica.estore.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Rajesh
*/

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="city")
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		System.out.println("In admin class getter method");
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("In admin class setter method");
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String cityName) {
		this.city = cityName;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id;
	}

}
