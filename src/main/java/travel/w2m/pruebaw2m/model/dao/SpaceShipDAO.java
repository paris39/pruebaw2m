/**
 * 
 */
package travel.w2m.pruebaw2m.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.w2m.pruebaw2m.model.entity.SpaceShipEntity;

@Repository (value = "spaceShipDAO")
public interface SpaceShipDAO extends JpaRepository<SpaceShipEntity, Integer> {

	/**
	 * Gets the space ship by content name.
	 *
	 * @param name
	 *        the name
	 * @return the space ship by content name
	 */
	public List<SpaceShipEntity> findByNameContains (String name);
}