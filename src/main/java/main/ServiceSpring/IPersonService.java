package main.java.main.ServiceSpring;

import java.util.Collection;
import main.java.main.Entitys.Person;

public interface IPersonService {
	Collection<Person> getAllPersons();

	Person getPersonById(int PersonId);

	boolean createPerson(Person Person);

	void updatePerson(Person Person);

	void deletePerson(int PersonId);
}