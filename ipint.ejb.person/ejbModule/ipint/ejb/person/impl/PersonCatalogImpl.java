package ipint.ejb.person.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ipint.ejb.person.PersonCatalogRemote;
import ipint.ejb.person.entities.Person;

@Stateless
public class PersonCatalogImpl implements PersonCatalogRemote {
	
	@PersistenceContext
	EntityManager em;
	
	public PersonCatalogImpl() {
		
	}

	@Override
	public Person createPerson(String firstname, String lastname, int age) {
		Person p = new Person();
		p.setFirstName(firstname);
		p.setLastName(lastname);
		p.setAge(age);
		em.persist(p);
		return p;
	}

	@Override
	public List<Person> listPerson() {
		return em.createQuery("select o from Person o").getResultList();
	}
}