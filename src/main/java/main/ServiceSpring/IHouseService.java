package main.java.main.ServiceSpring;

import java.util.Collection;

import main.java.main.Entitys.House;

public interface IHouseService {
	Collection<House> getAllHouses();

	House getHousebyName(String HouseName);

	boolean createHouse(House House);

	void deleteHouse(int HouseId);

	String updateHouse(int id, String name, String description, String state,
			int capacity, int price);
}