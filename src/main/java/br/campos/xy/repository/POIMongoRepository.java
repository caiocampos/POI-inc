package br.campos.xy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.campos.xy.model.document.POIDocument;

/**
 * 
 * @author Caio
 */
public interface POIMongoRepository extends MongoRepository<POIDocument, String> {

	POIDocument findByName(String name);

	@Query("{ 'location': { $near: [ ?0, ?1 ], $maxDistance: ?2} }")
	List<POIDocument> findByLocationDistance(Double x, Double y, Double distance);
}
