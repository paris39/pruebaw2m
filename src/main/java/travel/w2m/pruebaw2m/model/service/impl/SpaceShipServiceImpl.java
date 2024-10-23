package travel.w2m.pruebaw2m.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import travel.w2m.pruebaw2m.dto.SpaceShip;
import travel.w2m.pruebaw2m.model.dao.SpaceShipDAO;
import travel.w2m.pruebaw2m.model.entity.SpaceShipEntity;
import travel.w2m.pruebaw2m.model.mapper.SpaceShipMapper;
import travel.w2m.pruebaw2m.model.service.SpaceShipService;

@Service (value = "spaceShipService")
public class SpaceShipServiceImpl implements SpaceShipService {

	@Autowired
	private SpaceShipDAO spaceShipDAO;

	@Autowired
	private SpaceShipMapper spaceShipMapper;

	@Override
	public Optional<SpaceShip> getSpaceShipById (int id) {
		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.getReferenceById(id)));
	}

	@Override
	public Optional<List<SpaceShip>> getAllSpaceShips (Pageable pageable) {
		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.findAll(pageable).getContent()));
	}

	@Override
	public Optional<List<SpaceShip>> getSpaceShipByNameContains (String name) {
		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.findByNameContains(name)));
	}

	@Override
	public Optional<SpaceShip> createSpaceShip (String name) {
		SpaceShipEntity entity = new SpaceShipEntity();
		entity.setName(name);
		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.save(entity)));
	}

	@Override
	public Optional<SpaceShip> modifySpaceShip (SpaceShip spaceShip) {
		SpaceShipEntity spaceShipEntityAux = spaceShipDAO.getReferenceById(spaceShip.getId());
		spaceShipEntityAux.setName(spaceShip.getName());

		return Optional.ofNullable(spaceShipMapper.map(spaceShipDAO.save(spaceShipEntityAux)));
	}

	@Override
	public void deleteSpaceSihp (int id) {
		spaceShipDAO.deleteById(id);
	}

}
