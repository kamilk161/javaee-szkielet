package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Person;

@Stateless
public class PersonService {
	
	@PersistenceContext(unitName="unit")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPeople() {
		return (List<Person>)em.createQuery("SELECT p from Person p").getResultList();
	}
	
	public Person addPerson(String firstName, String lastName) {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		em.persist(person);
		return person;
	}
}
