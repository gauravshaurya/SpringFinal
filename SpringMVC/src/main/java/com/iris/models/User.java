package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_14Nov")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String role;
	
	@NotEmpty
	@Size(min=4,max=12,message="Password should be between 3 to 12 characters")
	@Column(name="UserPass")
	private String password;
	/*
	 * @ElementCollection(fetch=FetchType.EAGER)
	 * 
	 * @JoinTable(name="UserAddress",joinColumns=@JoinColumn(name="userId")) private
	 * Set<Address> addressSet=new HashSet();
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Set<Address> getAddressSet() { return addressSet; }
	 * 
	 * public void setAddressSet(Set<Address> addressSet) { this.addressSet =
	 * addressSet; }
	 */

	@Override
	public String toString() {
		return "User [UserId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", role=" + role + ", password=" + password + "]";
	}

}
