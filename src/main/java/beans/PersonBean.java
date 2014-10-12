package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.PersonService;

@ManagedBean
@ViewScoped
public class PersonBean {
	String firstName;
	
	String lastName;
	
	@EJB
	private PersonService ps;

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
	
	public void save() {
		ps.addPerson(firstName, lastName);
	}
}
