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

	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<List<SpaceShip>> getSpaceShips (Pageable pageable) {
		return spaceShipService.getAllSpaceShips(pageable);
	}

	@GetMapping (value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<SpaceShip> getSpaceShipById (@RequestParam (required = true) final Integer id) {
		return spaceShipService.getSpaceShipById(id);
	}

	@GetMapping (value = "/get/like", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<List<SpaceShip>> getSpaceShipByNameContains (
		@RequestParam (required = true) final String name) {
		return spaceShipService.getSpaceShipByNameContains(name);
	}

	@PutMapping (value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<SpaceShip> createSpaceShip (@RequestParam (required = true) final String name) {
		return spaceShipService.createSpaceShip(name);
	}

	@PatchMapping (value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
	public void modifySpaceShip (@RequestParam (required = true) final SpaceShip spaceShip) {
		spaceShipService.modifySpaceShip(spaceShip);
	}

	@DeleteMapping (value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteSpaceShip (@RequestParam (required = true) final int id) {
		spaceShipService.deleteSpaceSihp(id);
	}

}