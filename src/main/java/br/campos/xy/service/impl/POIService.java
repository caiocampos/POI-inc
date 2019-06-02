package br.campos.xy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.campos.xy.model.document.POIDocument;
import br.campos.xy.model.factory.AbstractDataFactory;
import br.campos.xy.model.factory.DocumentFactory;
import br.campos.xy.model.factory.ObjectDTOFactory;
import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.repository.POIMongoRepository;
import br.campos.xy.service.abst.IPOIService;
import br.campos.xy.util.XYException;

/**
 * Serviço de Pontos de Interesse
 * 
 * @author Caio
 */
@Service
public class POIService implements IPOIService {

	/**
	 * Instância de Repositório de Pontos de Interesse
	 */
	@Autowired
	POIMongoRepository poiMongoRepository;

	/**
	 * Cria um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento gerado
	 * @throws XYException
	 */
	public POIDocument create(POIDTO dto) throws XYException {
		try {
			POIDocument poi = this.parse(dto);
			this.validate(poi);
			return poiMongoRepository.save(poi);
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível salvar os dados", e);
		}
	}

	/**
	 * Atualiza um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento gerado
	 * @throws XYException
	 */
	public POIDocument update(POIDTO dto) throws XYException {
		try {
			POIDocument poi = this.find(dto);
			poi.setLocation(dto.getX(), dto.getY());
			this.validate(poi);
			return poiMongoRepository.save(poi);
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível salvar os dados", e);
		}
	}

	/**
	 * Busca um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento encontrado
	 * @throws XYException
	 */
	public POIDocument find(POIDTO dto) throws XYException {
		try {
			return poiMongoRepository.findByName(dto.getName());
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar o registro", e);
		}
	}

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 * 
	 * @param x        posição X de referência
	 * @param y        posição Y de referência
	 * @param distance Distância para a busca
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	public List<POIDocument> find(Double x, Double y, Double distance) throws XYException {
		try {
			return poiMongoRepository.findByLocationDistance(x, y, distance);
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

	/**
	 * Busca todos os Pontos de Interesse
	 * 
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	public List<POIDocument> find() throws XYException {
		try {
			return poiMongoRepository.findAll();
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

	/**
	 * Busca um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return dto do documento encontrado
	 * @throws XYException
	 */
	public POIDTO findDTO(POIDTO dto) throws XYException {
		try {
			POIDocument poi = this.find(dto);
			return this.parse(poi);
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível encontrar o registro", e);
		}
	}

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 * 
	 * @param x        posição X de referência
	 * @param y        posição Y de referência
	 * @param distance Distância para a busca
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	public List<POIDTO> findDTO(Double x, Double y, Double distance) throws XYException {
		try {
			List<POIDocument> list = this.find(x, y, distance);
			return parseAll(list);
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

	/**
	 * Busca todos os Pontos de Interesse
	 * 
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	public List<POIDTO> findDTO() throws XYException {
		try {
			List<POIDocument> list = this.find();
			return parseAll(list);
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

	/**
	 * Apaga um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @throws XYException
	 */
	public void delete(POIDTO dto) throws XYException {
		try {
			POIDocument poi = this.find(dto);
			poiMongoRepository.deleteById(poi.getId());
		} catch (Exception e) {
			if (e instanceof XYException) {
				throw e;
			}
			throw new XYException("Não foi possível apagar o registro", e);
		}
	}

	/**
	 * Apaga todos os Pontos de Interesse
	 * 
	 * @throws XYException
	 */
	public void deleteAll() throws XYException {
		try {
			poiMongoRepository.deleteAll();
		} catch (Exception e) {
			throw new XYException("Não foi possível apagar os registros", e);
		}
	}

	/**
	 * Converte formatos de Ponto de Interesse
	 * 
	 * @param dto Ponto de Interesse no formato DTO
	 * @return Ponto de Interesse no formato Documento
	 * @throws XYException
	 */
	private POIDocument parse(POIDTO dto) throws XYException {
		try {
			DocumentFactory factory = AbstractDataFactory.getFactory(dto);
			return (POIDocument) factory.create(dto);
		} catch (Exception e) {
			throw new XYException("Não foi possível converter o tipo de dados", e);
		}
	}

	/**
	 * Converte formatos de Ponto de Interesse
	 * 
	 * @param dto Ponto de Interesse no formato Documento
	 * @return Ponto de Interesse no formato DTO
	 * @throws XYException
	 */
	private POIDTO parse(POIDocument doc) throws XYException {
		try {
			ObjectDTOFactory factory = AbstractDataFactory.getFactory(doc);
			return (POIDTO) factory.create(doc);
		} catch (Exception e) {
			throw new XYException("Não foi possível converter o tipo de dados", e);
		}
	}

	/**
	 * Converte formatos de Pontos de Interesse
	 * 
	 * @param list lista de Pontos de Interesse no formato Documento
	 * @return lista de Pontos de Interesse no formato DTO
	 * @throws XYException
	 */
	private List<POIDTO> parseAll(List<POIDocument> list) throws XYException {
		try {
			return list.parallelStream().map(doc -> {
				try {
					return this.parse(doc);
				} catch (Exception e) {
					return null;
				}
			}).filter(dto -> dto != null).collect(Collectors.toList());
		} catch (Exception e) {
			throw new XYException("Não foi possível converter o tipo de dados", e);
		}
	}

	/**
	 * Valida um Pontos de Interesse
	 * 
	 * @param poi documento de Pontos de Interesse
	 * @throws XYException
	 */
	private void validate(POIDocument poi) throws XYException {
		if (poi.getName() == null || poi.getName().isEmpty()) {
			throw new XYException("O nome não pode estar vazio");
		} else if (poi.getX().compareTo(0D) == -1) {
			throw new XYException("Valor de X não pode ser negativo");
		} else if (poi.getY().compareTo(0D) == -1) {
			throw new XYException("Valor de Y não pode ser negativo");
		}
	}

}
