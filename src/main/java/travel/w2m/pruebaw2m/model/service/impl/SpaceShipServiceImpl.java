package travel.w2m.pruebaw2m.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import travel.w2m.pruebaw2m.dto.SpaceShip;
import travel.w2m.pruebaw2m.model.dao.SpaceShipDAO;
import travel.w2m.pruebaw2m.model.entity.SpaceShipEntity;
import travel.w2m.pruebaw2m.model.mapper.SpaceShipMapper;
import travel.w2m.pruebaw2m.model.service.SpaceShipService;

@Slf4j
@Service (value = "spaceShipService")
public class SpaceShipServiceImpl implements SpaceShipService {

	@Autowired
	private SpaceShipDAO spaceShipDAO;

	@Autowired
	private SpaceShipMapper spaceShipMapper;

	private List<SpaceShip> spaceShipListCache;

	@Override
	public Optional<SpaceShip> getSpaceShipById (Integer id) {
		// Comprobación de caché
		if (null == spaceShipListCache || 0 == spaceShipListCache.size()) {
			refreshCache();
		}
		// return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.getReferenceById(id)));
		log.info("Búsqueda por ID: {}", id);
		return Optional
			.ofNullable(spaceShipListCache.stream().filter(spaceShip -> spaceShip.getId().equals(id)).findAny()
				.orElse(null));
	}

	@Override
	public Optional<List<SpaceShip>> getAllSpaceShips (Pageable pageable) {
		// Comprobación de caché
		if (null == spaceShipListCache || 0 == spaceShipListCache.size()) {
			refreshCache();
		}
		log.info("Búsqueda paginada: {}", pageable.toString());
		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.findAll(pageable).getContent()));
	}

	@Override
	public Optional<List<SpaceShip>> getSpaceShipByNameContains (String name) {
		// Comprobación de caché+
		if (null == spaceShipListCache || 0 == spaceShipListCache.size()) {
			refreshCache();
		}
		// return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.findByNameContains(name)));
		log.info("Búsqueda por nombre: '{}'", name);
		return Optional
			.ofNullable(
				spaceShipListCache.stream().filter(spaceShip -> spaceShip.getName().contains(new StringBuffer(name)))
					.collect(Collectors.toList()));
	}

	@Override
	public Optional<SpaceShip> createSpaceShip (String name) {
		SpaceShipEntity entity = new SpaceShipEntity();
		entity.setName(name);

		Optional<SpaceShip> result = Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.save(entity)));
		log.info("Se ha guardado el registro {} en BBDD correctamente", result.get().getId());
		refreshCache();

		return result;
	}

	@Override
	public Optional<SpaceShip> modifySpaceShip (SpaceShip spaceShip) {
		SpaceShipEntity spaceShipEntityAux = spaceShipDAO.getReferenceById(spaceShip.getId());
		spaceShipEntityAux.setName(spaceShip.getName());

		Optional<SpaceShip> result = Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.save(spaceShipEntityAux)));
		log.info("Se ha modificado el registro {} en BBDD correctamente", result.get().getId());
		refreshCache();

		return result;
	}

	@Override
	public void deleteSpaceSihp (Integer id) {
		spaceShipDAO.deleteById(id);
		log.info("Se ha eliminado el registro {} en BBDD correctamente", id);
		refreshCache();
	}

	/**
	 * Refresh cache.
	 */
	private void refreshCache () {
		if (spaceShipListCache != null) {
			spaceShipListCache.clear();
		}
		spaceShipListCache = spaceShipMapper.map((spaceShipDAO.findAll()));
		log.debug("Se ha refrescado la caché de resultados");
	}
}