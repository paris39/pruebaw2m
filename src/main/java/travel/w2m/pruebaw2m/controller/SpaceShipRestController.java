package travel.w2m.pruebaw2m.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import travel.w2m.pruebaw2m.dto.SpaceShip;
import travel.w2m.pruebaw2m.model.service.SpaceShipService;

@Data
@RestController
@RequestMapping ("/spaceShips")
public class SpaceShipRestController {

	@Autowired
	private SpaceShipService spaceShipService;

	/**
	 * Gets the space ships.
	 *
	 * @param pageable
	 *        the pageable
	 * @return the space ships
	 */
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<List<SpaceShip>> getSpaceShips (Pageable pageable) {
		return spaceShipService.getAllSpaceShips(pageable);
	}

	/**
	 * Gets the space ship by id.
	 *
	 * @param id
	 *        the id
	 * @return the space ship by id
	 */
	@GetMapping (value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<SpaceShip> getSpaceShipById (@RequestParam (required = true) final Integer id) {
		return spaceShipService.getSpaceShipById(id);
	}

	/**
	 * Gets the space ship by name contains.
	 *
	 * @param name
	 *        the name
	 * @return the space ship by name contains
	 */
	@GetMapping (value = "/get/like", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<List<SpaceShip>> getSpaceShipByNameContains (
		@RequestParam (required = true) final String name) {
		return spaceShipService.getSpaceShipByNameContains(name);
	}

	/**
	 * Creates the space ship.
	 *
	 * @param name
	 *        the name
	 * @return the optional
	 */
	@PutMapping (value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<SpaceShip> createSpaceShip (@RequestParam (required = true) final String name) {
		return spaceShipService.createSpaceShip(name);
	}

	/**
	 * Modify space ship.
	 *
	 * @param spaceShip
	 *        the space ship
	 */
	@PatchMapping (value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
	public void modifySpaceShip (@RequestBody (required = true) final SpaceShip spaceShip) {
		spaceShipService.modifySpaceShip(spaceShip);
	}

	/**
	 * Delete space ship.
	 *
	 * @param id
	 *        the id
	 */
	@DeleteMapping (value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteSpaceShip (@RequestParam (required = true) final int id) {
		spaceShipService.deleteSpaceSihp(id);
	}

}