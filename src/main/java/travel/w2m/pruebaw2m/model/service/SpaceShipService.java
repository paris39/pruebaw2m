package travel.w2m.pruebaw2m.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import travel.w2m.pruebaw2m.dto.SpaceShip;

/**
 * The Interface SpaceShipService.
 */
@Service
public interface SpaceShipService {

	/**
	 * Gets the space ship by id.
	 *
	 * @param id
	 *        the id
	 * @return the space ship by id
	 */
	public Optional<SpaceShip> getSpaceShipById (int id);

	/**
	 * Gets the space ships.
	 *
	 * @return the space ships
	 */
	public Optional<List<SpaceShip>> getAllSpaceShips (Pageable pageable);

	/**
	 * Gets the space ship by name contains.
	 *
	 * @param name
	 *        the name
	 * @return the space ship by name contains
	 */
	public Optional<List<SpaceShip>> getSpaceShipByNameContains (String name);

	/**
	 * Creates the space ship.
	 *
	 * @param name
	 *        the name
	 * @return the space ship
	 */
	public Optional<SpaceShip> createSpaceShip (String name);

	/**
	 * Modify space ship.
	 *
	 * @param spaceShip
	 *        the space ship
	 */
	public Optional<SpaceShip> modifySpaceShip (SpaceShip spaceShip);

	/**
	 * Delete space sihp.
	 *
	 * @param id
	 *        the id
	 */
	public void deleteSpaceSihp (int id);
}
