package main.java.main.Controller;

import java.util.Collection;

import main.java.main.Entitys.House;
import main.java.main.ServiceSpring.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

	@Autowired
	private HouseService houseService;

	@RequestMapping(value = "/houses/get-all", method = RequestMethod.GET)
	public Collection<House> getAllHouses() {
		return houseService.getAllHouses();
	}

	@RequestMapping(value = "/houses/get/id={id}", method = RequestMethod.GET)
	public House getHousebyId(
			@PathVariable(value = "id", required = true) int id)

	{
		return houseService.getHousebyId(id);
	}

	@RequestMapping(value = "/houses/update/", method = RequestMethod.POST)
	/*
	 * int id, String name, String description, String state, int capacity, int
	 * price
	 */
	public String updateHouse(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("state") String state,
			@RequestParam("capacity") int capacity,
			@RequestParam("price") int price

			) {

		return houseService.updateHouse(id, name, description, state, capacity,
				price);
	}

}
