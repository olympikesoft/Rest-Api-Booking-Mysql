package main.java.main.DAO;

import java.util.Collection;
import main.java.main.Entitys.Person;

public interface PersonDAO {
	Collection<Person> getAllPersons();

	Person getPersonById(int PersonId);

	void createPerson(Person Person);

	void updatePerson(Person Person);

	void deletePerson(int PersonId);

	boolean PersonExists(String name, String sobrename);
}
