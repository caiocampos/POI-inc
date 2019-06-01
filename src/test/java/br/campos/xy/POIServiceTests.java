package br.campos.xy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.service.abst.IPOIService;
import br.campos.xy.util.XYException;

/**
 * 
 * @author Caio
 */
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = XyIncApplication.class)
public class POIServiceTests {
	@Autowired
	IPOIService poiService;

	//@Test
	public void create() throws XYException {
		final Double mOne = Double.valueOf(-1);
		final Double dValue = Double.valueOf(1435674.003);
		assertThrows(XYException.class, () -> {
			poiService.create(null);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, null, null);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, mOne, null);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, null, mOne);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("A", null, null);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("B", mOne, null);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("C", null, mOne);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("D", mOne, dValue);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("E", dValue, mOne);
			poiService.create(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("", dValue, dValue);
			poiService.create(dto);
		});
		POIDTO dtoO = new POIDTO("F", dValue, dValue);
		assertNotNull(poiService.create(dtoO));
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("F", dValue, dValue);
			poiService.create(dto);
		});
		dtoO = new POIDTO("G", 0D, 10D);
		assertNotNull(poiService.create(dtoO));
		dtoO = new POIDTO("H", 10D, 0D);
		assertNotNull(poiService.create(dtoO));
	}

	@Test
	public void update() throws XYException {
		final Double mOne = Double.valueOf(-1);
		final Double dValue = Double.valueOf(1435674.003);
		assertThrows(XYException.class, () -> {
			poiService.update(null);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, null, null);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("", dValue, dValue);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("A", dValue, dValue);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("F", mOne, null);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("F", null, mOne);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("F", mOne, dValue);
			poiService.update(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("F", dValue, mOne);
			poiService.update(dto);
		});
		POIDTO dtoO = new POIDTO("F", 1D, 10D);
		assertNotNull(poiService.update(dtoO));
	}

	@Test
	public void findDTO() throws XYException {
		assertThrows(XYException.class, () -> {
			poiService.findDTO(null);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, null, null);
			poiService.findDTO(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("", null, null);
			poiService.findDTO(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("A", null, null);
			poiService.findDTO(dto);
		});
		POIDTO dtoO = new POIDTO("H", null, null);
		assertNotEquals(poiService.findDTO(dtoO).toString(), "POIDTO(nome=H, x=10, y=0)");

		assertTrue(poiService.findDTO(0D, 0D, 0D).isEmpty());
		assertTrue(poiService.findDTO(0D, 0D, 10D).size() == 2);

		assertTrue(poiService.findDTO().size() == 3);
	}

	//@Test
	public void delete() throws XYException {
		assertThrows(XYException.class, () -> {
			poiService.delete(null);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO(null, null, null);
			poiService.delete(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("", null, null);
			poiService.delete(dto);
		});
		assertThrows(XYException.class, () -> {
			POIDTO dto = new POIDTO("A", null, null);
			poiService.delete(dto);
		});
		POIDTO dtoO = new POIDTO("G", null, null);
		
		poiService.delete(dtoO);
	}

	//@Test
	public void deleteAll() throws XYException {
		poiService.deleteAll();
	}
}
