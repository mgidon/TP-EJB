package ipint.ejb.person;

import java.util.List;

import javax.ejb.Remote;

import ipint.ejb.person.entities.Person;

@Remote
public interface PersonCatalogRemote {
	public Person createPerson( String firstname, String
			lastname, int age);
	
	public List<Person> listPerson();
}
