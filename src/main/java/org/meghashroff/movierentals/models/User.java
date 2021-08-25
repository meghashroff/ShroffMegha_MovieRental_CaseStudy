package org.meghashroff.movierentals.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "firstName", nullable=false, length=255)
	@NotEmpty (message = "Name cant be empty.")
//	@Size(min=1, message = "Please enter your first name")
	private String firstName;
	
	private String lastName;
	
	@Column(name = "username", nullable=false, length=255, unique=true)
	@NotEmpty (message = "Username cant be empty.")
	private String username;
	
	@Column(name = "email", nullable=false, length=255)
//	@NotEmpty(message="Email cant be empty")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email")
	private String email;

	@Column(name = "password", nullable=false, length=100)
	@NotEmpty (message = "Password cant be empty")
	private String password;
	
	@Size(min=10, max=10, message = "Should be 10 digits")
	private String phoneNo;
	
	@OneToMany(targetEntity = RentalTransaction.class, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<RentalTransaction> rentalTrans;
	
	public User() {
		this.rentalTrans = new ArrayList<>();
	}
	
//	public User(String firstName, String lastName, String email, String password, String phoneNo,
//			List<RentalTransaction> rentalTrans) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.phoneNo = phoneNo;
//		this.rentalTrans = rentalTrans;
//	}

	public User(String firstName, String lastName, String username, String email, String password, String phoneNo)	{
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username= username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

//	public User(Integer userId, String firstName, String lastName, String email, String password, String phoneNo,
//			List<RentalTransaction> rentalTrans) {
//		this.userId = userId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.phoneNo = phoneNo;
//		this.rentalTrans = rentalTrans;
//	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public List<RentalTransaction> getRentalTrans() {
		return rentalTrans;
	}
	
	public void setRentalTrans(List<RentalTransaction> rentalTrans) {
		this.rentalTrans = rentalTrans;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNo=" + phoneNo + ", rentalTrans=" + rentalTrans + "]";
	}
	
		
}
