package crudOperation.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user")
public class User {
	@NotEmpty(message="*Username can't be empty")
	@Column(name="username")
	@Id
	public String username;
	
	@NotEmpty(message="*Email can't be empty") @Email(message="*Invalid Email")
	@Column(name="email")
	public String email;
	
	@NotEmpty(message="*Age can't be empty")
	@Column(name="age")
	String age;
	
	@NotEmpty(message="*Phone can't be empty")
	public String phone;
	
	
	
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
