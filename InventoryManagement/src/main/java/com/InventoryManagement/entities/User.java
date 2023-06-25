// entity class represents a persistent data object that maps to a database table.
package com.InventoryManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_table")

@NoArgsConstructor
@Getter
@Setter


public class User {

	
	private int id;
	//Backend Validation
	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail.com+$")
	@Column(unique=true)
	private String email;
	
	 @NotEmpty(message = "Password is required")
	
	 @Size(min = 8, message = "Password should be at least 8 characters")
	private String password;
	 
	 @NotEmpty(message = "Address is required")
     private String Address;
	 
	 
     @NotEmpty(message = "Phone is required")
     @Pattern(regexp="^[6-9]\\d{9}$")
	private String phone;
     
     @NotEmpty(message = "Account type is required")
	private String accountType;
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	

}
