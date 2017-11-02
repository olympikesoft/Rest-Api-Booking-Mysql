package main.java.main.ServiceSpring;

import java.util.Collection;
import main.java.main.DAO.IPersonDAO;
import main.java.main.Entitys.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDAO PersonDAO;

	@Override
	public Person getPersonById(int PersonId) {
		Person obj = PersonDAO.getPersonById(PersonId);
		return obj;
	}

	@Override
	public Collection<Person> getAllPersons() {
		return PersonDAO.getAllPersons();
	}

	@Override
	public synchronized boolean createPerson(Person Person) {
		if (PersonDAO.PersonExists(Person.getName(), Person.getSobrename())) {
			return false;
		} else {
			PersonDAO.createPerson(Person);
			return true;
		}
	}

	@Override
	public void updatePerson(Person Person) {
		PersonDAO.updatePerson(Person);
	}

	@Override
	public void deletePerson(int PersonId) {
		PersonDAO.deletePerson(PersonId);
	}

}