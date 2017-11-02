package main.java.main.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.main.Entitys.House;
import main.java.main.Entitys.Person;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("house")
public class IHouseDAO implements HouseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static class HouseRowMapper implements RowMapper<House> {

		@Override
		public House mapRow(ResultSet resultSet, int i) throws SQLException {
			House House = new House();
			House.setId(resultSet.getInt("id"));
			House.setName(resultSet.getString("name"));
			House.setDescription(resultSet.getString("description"));
			House.setCapacity(resultSet.getInt("capacity"));
			House.setState(resultSet.getString("state"));
			House.setPrice(resultSet.getInt("price"));
			House.setLocalization(resultSet.getString("localization"));
			House.setImage_url(resultSet.getString("image_url"));
			House.setLikes(resultSet.getInt("likes"));

			return House;
		}
	}

	@Override
	public Collection<House> getAllHouses() {
		// SELECT column_name(s) FROM table_name
		final String sql = "SELECT * FROM house";
		List<House> houses = jdbcTemplate.query(sql, new HouseRowMapper());
		return houses;
	}

	public House getHousebyName(String name) {
		// SELECT column_name(s) FROM table_name where column = value
		final String sql = "SELECT * FROM house where name = ?";
		House houses = jdbcTemplate.queryForObject(sql, new HouseRowMapper(),
				name);
		return houses;
	}

	@Override
	public void createHouse(House house) {
		/*
		 * final String sql =
		 * "INSERT INTO Person (name, sobrename, email, country, birthday) VALUES (?, ?, ?, ?, ?)"
		 * ; final String name = Person.getName(); final String sobrename =
		 * Person.getSobrename(); final String email = Person.getEmail(); final
		 * String country = Person.getCountry(); final String birthday =
		 * Person.getBirthday(); jdbcTemplate.update(sql, new Object[] { name,
		 * sobrename, email, country, birthday });
		 */
	}

	@Override
	public String updateHouse(int id, String name, String description,
			String state, int capacity, int price) {
		House house;

		final String sql = "SELECT * FROM house where id = ?";
		House houses = jdbcTemplate.queryForObject(sql, new HouseRowMapper(),
				id);

		house = houses;
		house.setName(name);
		house.setDescription(description);
		house.setState(state);
		house.setCapacity(capacity);
		house.setPrice(price);

		final String update = "update house set name = ?, description = ? , state = ? , capacity = ?, price = ? WHERE id = ?";
		try {
			this.jdbcTemplate.update(update, name, description, state,
					capacity, price, id);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update.toString();

	}

	public boolean HouseExists(String name, String description) {
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
	public void deleteHouse(int id) {
		// DELETE FROM table_name
		// WHERE some_column = some_value
		final String sql = "DELETE FROM house WHERE id = ?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public Person getHouseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public House getHousebyID(int id) {
		final String sql = "SELECT * FROM house where id = ?";
		House houses = jdbcTemplate.queryForObject(sql, new HouseRowMapper(),
				id);
		return houses;
	}

}
