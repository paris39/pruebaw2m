package travel.w2m.pruebaw2m;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import travel.w2m.pruebaw2m.controller.SpaceShipRestController;
import travel.w2m.pruebaw2m.dto.SpaceShip;
import travel.w2m.pruebaw2m.model.service.SpaceShipService;

@WebMvcTest (SpaceShipRestController.class)
@SpringBootTest
public class SpaceShiptControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	SpaceShipService spaceShipService;

	@Test
	public void getSpaceShipById () throws Exception {
		SpaceShip spaceShip = new SpaceShip();
		spaceShip.setId(1);
		spaceShip.setName("Halcón Milenario");

		org.mockito.BDDMockito.given(spaceShipService.getSpaceShipById(Mockito.anyInt()))
			.willReturn(Optional.of(spaceShip));

		mockMvc
			.perform(get("/spaceShips/get").param("id", "1")
				.accept(org.springframework.http.MediaType.parseMediaType("application/json")))
			.andExpect(status().isNotFound());
	}

	@Test
	public void getSpaceShips () throws Exception {
		mockMvc.perform(get("/spaceShips")).andExpect(status().isOk());
	}
}