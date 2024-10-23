package travel.w2m.pruebaw2m.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "SPACE_SHIP")
@Data
public class SpaceShipEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (name = "NAME", length = 50, nullable = false, unique = true)
	private String name;
}