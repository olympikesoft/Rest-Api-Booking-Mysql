package main.java.main.ServiceSpring;

import java.util.Collection;

import main.java.main.DAO.IHouseDAO;
import main.java.main.Entitys.House;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements IHouseService {

	@Autowired
	private IHouseDAO HouseDAO;

	@Override
	public Collection<House> getAllHouses() {
		return HouseDAO.getAllHouses();
	}

	@Override
	public House getHousebyName(String HouseName) {
		House obj = HouseDAO.getHousebyName(HouseName);
		return obj;
	}

	@Override
	public boolean createHouse(House House) {
		if (HouseDAO.HouseExists(House.getName(), House.getDescription())) {
			return false;
		} else {
			HouseDAO.createHouse(House);
			return true;
		}
	}

	@Override
	public String updateHouse(int id, String name, String description,
			String state, int capacity, int price) {
		return HouseDAO.updateHouse(id, name, description, state, capacity,
				price);
	}

	@Override
	public void deleteHouse(int HouseId) {
		HouseDAO.deleteHouse(HouseId);

	}

	public House getHousebyId(int id) {
		House obj = HouseDAO.getHousebyID(id);
		return obj;
	}

}
