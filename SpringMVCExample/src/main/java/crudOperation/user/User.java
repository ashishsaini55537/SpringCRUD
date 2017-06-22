package crudOperation.user;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class User {
	@NotEmpty(message="*Username can't be empty")
	public String username;
	
	@NotEmpty(message="*Email can't be empty") @Email(message="*Invalid Email")
	public String email;
	
	@NotEmpty(message="*Age can't be empty")
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
