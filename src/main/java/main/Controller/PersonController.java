package main.java.main.Controller;

import main.java.main.ServiceSpring.PersonService;
import main.java.main.Entitys.Person;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
// @CrossOrigin(origins = { "http://localhost/book" })
// @RequestMapping("/user/")
public class PersonController {

	@Autowired
	private PersonService studentService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	public Collection<Person> getAllStudents() {
		return studentService.getAllPersons();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Person getPersonById(
			@RequestParam(value = "id", required = true) int id)

	{
		return studentService.getPersonById(id);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable("id") int id) {
		studentService.deletePerson(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Person person) {
		studentService.createPerson(person);
	}
}