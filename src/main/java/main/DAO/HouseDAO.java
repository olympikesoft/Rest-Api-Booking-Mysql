package main.java.main.DAO;

import java.util.Collection;

import main.java.main.Entitys.House;
import main.java.main.Entitys.Person;

//Acess methods of House object Pojo
public interface HouseDAO {
	Collection<House> getAllHouses();

	Person getHouseByName(String name);

	void createHouse(House house);

	void deleteHouse(int HouseId);

	String updateHouse(int id, String name, String description, String state,
			int capacity, int price);

}
