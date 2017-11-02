package main.java.main.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import main.java.main.Entitys.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("person")
public class IPersonDAO implements PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet resultSet, int i) throws SQLException {
			Person person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setSobrename(resultSet.getString("sobrename"));
			person.setEmail(resultSet.getString("email"));
			person.setCountry(resultSet.getString("country"));
			person.setBirthday(resultSet.getString("birthday"));

			return person;
		}
	}

	@Override
	public Collection<Person> getAllPersons() {
		// SELECT column_name(s) FROM table_name
		final String sql = "SELECT * FROM person";
		List<Person> persons = jdbcTemplate.query(sql, new PersonRowMapper());
		return persons;
	}

	@Override
	public Person getPersonById(int id) {
		// SELECT column_name(s) FROM table_name where column = value
		final String sql = "SELECT * FROM person where id = ?";
		Person person = jdbcTemplate.queryForObject(sql, new PersonRowMapper(),
				id);
		return person;
	}

	@Override
	public void createPerson(Person Person) {
		final String sql = "INSERT INTO Person (name, sobrename, email, country, birthday) VALUES (?, ?, ?, ?, ?)";
		final String name = Person.getName();
		final String sobrename = Person.getSobrename();
		final String email = Person.getEmail();
		final String country = Person.getCountry();
		final String birthday = Person.getBirthday();
		jdbcTemplate.update(sql, new Object[] { name, sobrename, email,
				country, birthday });
	}

	@Override
	public void updatePerson(Person Person) {
		/*
		 * Person person = getPersonById(Person.getId());
		 * person.setName(person.getName());
		 * person.setSobrename(person.getSobrename());
		 * person.setEmail(person.getEmail());
		 * 
		 * // COMMIT the persitence of the data entityManager.flush();
		 */

	}

	@Override
	public boolean PersonExists(String name, String sobrename) {
		return false;
		/*
		 * String hql = "FROM person as p WHERE p.name = ? and p.sobrename = ?";
		 * int count = entityManager.createQuery(hql).setParameter(1, name)
		 * .setParameter(2, sobrename).getResultList().size();
		 * 
		 * if (count > 0) { return true; } else { return false; }
		 */

	}

	@Override
	public void deletePerson(int id) {
		// DELETE FROM table_name
		// WHERE some_column = some_value
		final String sql = "DELETE FROM person WHERE id = ?";
		jdbcTemplate.update(sql, id);

	}

	// TODO Auto-generated method stub

}
