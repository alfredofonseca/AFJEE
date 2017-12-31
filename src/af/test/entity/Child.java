package af.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Child {

	@Id
	private Integer id;
	
	private String firstname;
	private String lastname;
	
	
	
	
	public Child() {
		
	}
	
	public Child(Integer id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}


	@Override
	public String toString() {
		return "Child [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		
}
