package br.campos.poi.service.impl

import br.campos.poi.model.document.POIDocument
import br.campos.poi.model.factory.AbstractDataFactory
import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.repository.POIMongoRepository
import br.campos.poi.service.abst.IPOIService
import br.campos.poi.util.POIException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Serviço de Pontos de Interesse
 *
 * @author Caio
 */
@Service
class POIService : IPOIService {

	/**
	 * Instância de Repositório de Pontos de Interesse
	 */
	@Autowired
	lateinit var poiMongoRepository: POIMongoRepository

	override fun create(dto: POIDTO?): POIDocument {
		try {
			val poi = parse(dto)
			validate(poi)
			return poiMongoRepository.save(poi)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível salvar os dados", e)
		}
	}

	override fun update(dto: POIDTO?): POIDocument {
		try {
			val poi = find(dto)
			poi.setLocation(dto?.x, dto?.y)
			validate(poi)
			return poiMongoRepository.save(poi)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível salvar os dados", e)
		}
	}

	override fun find(dto: POIDTO?): POIDocument {
		try {
			return poiMongoRepository.findByName(dto!!.name!!)!!
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível encontrar o registro", e)
		}
	}

	override fun find(x: Double?, y: Double?, distance: Double?): List<POIDocument> {
		try {
			return poiMongoRepository.findByLocationDistance(x!!, y!!, distance!!)
		} catch (e: Exception) {
			throw POIException("Não foi possível encontrar os registros", e)
		}
	}

	override fun find(): List<POIDocument> {
		try {
			return poiMongoRepository.findAll()
		} catch (e: Exception) {
			throw POIException("Não foi possível encontrar os registros", e)
		}
	}

	override fun findDTO(dto: POIDTO?): POIDTO {
		try {
			val poi = find(dto)
			return parse(poi)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível encontrar o registro", e)
		}
	}

	override fun findDTO(x: Double?, y: Double?, distance: Double?): List<POIDTO> {
		try {
			val list = find(x, y, distance)
			return parseAll(list)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível encontrar os registros", e)
		}
	}

	override fun findDTO(): List<POIDTO> {
		try {
			val list = find()
			return parseAll(list)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível encontrar os registros", e)
		}
	}

	override fun delete(dto: POIDTO?) {
		try {
			val poi = find(dto)
			poiMongoRepository.deleteById(poi.id!!)
		} catch (e: Exception) {
			throw if (e is POIException) e else POIException("Não foi possível apagar o registro", e)
		}
	}

	override fun deleteAll() {
		try {
			poiMongoRepository.deleteAll()
		} catch (e: Exception) {
			throw POIException("Não foi possível apagar os registros", e)
		}
	}

	/**
	 * Converte formatos de Ponto de Interesse (DTO -> Documento)
	 */
	private fun parse(dto: POIDTO?): POIDocument {
		try {
			val factory = AbstractDataFactory.getFactory(dto!!)
			return factory!!.create(dto) as POIDocument
		} catch (e: Exception) {
			throw POIException("Não foi possível converter o tipo de dados", e)
		}
	}

	/**
	 * Converte formatos de Ponto de Interesse (Documento -> DTO)
	 */
	private fun parse(doc: POIDocument?): POIDTO {
		try {
			val factory = AbstractDataFactory.getFactory(doc!!)
			return factory!!.create(doc) as POIDTO
		} catch (e: Exception) {
			throw POIException("Não foi possível converter o tipo de dados", e)
		}
	}

	/**
	 * Converte formatos de Pontos de Interesse
	 */
	private fun parseAll(list: List<POIDocument>): List<POIDTO> {
		try {
			return list.parallelStream()
				.map { doc ->
					try {
						parse(doc)
					} catch (e: Exception) {
						null
					}
				}
				.filter { it != null }
				.map { it!! }
				.toList()
		} catch (e: Exception) {
			throw POIException("Não foi possível converter o tipo de dados", e)
		}
	}

	/**
	 * Valida um Ponto de Interesse
	 */
	private fun validate(poi: POIDocument) {
		if (poi.name.isNullOrEmpty()) {
			throw POIException("O nome não pode estar vazio")
		} else if (poi.x!!.compareTo(0.0) == -1) {
			throw POIException("Valor de X não pode ser negativo")
		} else if (poi.y!!.compareTo(0.0) == -1) {
			throw POIException("Valor de Y não pode ser negativo")
		}
	}
}
