package travel.w2m.pruebaw2m.model.mapper;

import org.springframework.stereotype.Component;

import travel.w2m.pruebaw2m.dto.SpaceShip;
import travel.w2m.pruebaw2m.model.entity.SpaceShipEntity;

@Component
public class SpaceShipMapper extends AbstractMapper<SpaceShip, SpaceShipEntity> {

	@Override
	public SpaceShip map (SpaceShipEntity entity) {
		SpaceShip spaceShip = new SpaceShip();
		spaceShip.setId(entity.getId());
		spaceShip.setName(entity.getName());

		return spaceShip;
	}

	@Override
	public SpaceShipEntity mapAux (SpaceShip item) {
		SpaceShipEntity spaceShipEntity = new SpaceShipEntity();
		spaceShipEntity.setId(item.getId());
		spaceShipEntity.setName(item.getName());

		return spaceShipEntity;
	}

}