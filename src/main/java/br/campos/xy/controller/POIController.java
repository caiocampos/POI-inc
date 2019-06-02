package br.campos.xy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.model.transfer.POINearDTO;
import br.campos.xy.service.abst.IPOIService;
import br.campos.xy.util.XYException;

/**
 * Controle de Pontos de Interesse
 * 
 * @author Caio
 */
@RestController("poi")
public class POIController {

	/**
	 * Instância de Serviço de Pontos de Interesse
	 */
	@Autowired
	IPOIService poiService;

	/**
	 * Busca todos os Pontos de Interesse
	 * 
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<POIDTO>> findAll() throws XYException {
		return new ResponseEntity<>(poiService.findDTO(), HttpStatus.OK);
	}

	/**
	 * Busca os Pontos de Interesse a uma certa distancia
	 * 
	 * @param req - Objeto contendo o ponto inicial e a distancia de busca
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	@GetMapping("/near")
	public @ResponseBody ResponseEntity<List<POIDTO>> findNear(@RequestBody POINearDTO req) throws XYException {
		return new ResponseEntity<>(poiService.findDTO(req.getX(), req.getY(), req.getDistance()), HttpStatus.OK);
	}

	/**
	 * Cria Pontos de Interesse
	 * 
	 * @param req - Objeto contendo os dados do Ponto de Interesse
	 * @return instância de Ponto de Interesse do banco de dados
	 * @throws XYException
	 */
	@PostMapping("/")
	public @ResponseBody ResponseEntity<Object> create(@RequestBody POIDTO req) throws XYException {
		return new ResponseEntity<>(poiService.create(req), HttpStatus.OK);
	}

}
