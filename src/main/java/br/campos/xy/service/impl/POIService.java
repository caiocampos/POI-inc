package br.campos.xy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.campos.xy.model.abst.AbstractDataFactory;
import br.campos.xy.model.abst.DocumentFactory;
import br.campos.xy.model.abst.ObjectDTOFactory;
import br.campos.xy.model.document.POIDocument;
import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.repository.POIMongoRepository;
import br.campos.xy.service.abst.IPOIService;
import br.campos.xy.util.XYException;

/**
 *
 * @author Caio
 */
@Service
public class POIService implements IPOIService {

	@Autowired
	POIMongoRepository poiMongoRepository;

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

	public POIDocument find(POIDTO dto) throws XYException {
		try {
			return poiMongoRepository.findByName(dto.getName());
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar o registro", e);
		}
	}

	public List<POIDocument> find(Double x, Double y, Double distance) throws XYException {
		try {
			return poiMongoRepository.findByLocationDistance(x, y, distance);
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

	public List<POIDocument> find() throws XYException {
		try {
			return poiMongoRepository.findAll();
		} catch (Exception e) {
			throw new XYException("Não foi possível encontrar os registros", e);
		}
	}

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

	public void deleteAll() throws XYException {
		try {
			poiMongoRepository.deleteAll();
		} catch (Exception e) {
			throw new XYException("Não foi possível apagar os registros", e);
		}
	}

	private POIDocument parse(POIDTO dto) throws XYException {
		try {
			DocumentFactory factory = AbstractDataFactory.getFactory(dto);
			return (POIDocument) factory.create(dto);
		} catch (Exception e) {
			throw new XYException("Não foi possível converter o tipo de dados", e);
		}
	}

	private POIDTO parse(POIDocument doc) throws XYException {
		try {
			ObjectDTOFactory factory = AbstractDataFactory.getFactory(doc);
			return (POIDTO) factory.create(doc);
		} catch (Exception e) {
			throw new XYException("Não foi possível converter o tipo de dados", e);
		}
	}

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
