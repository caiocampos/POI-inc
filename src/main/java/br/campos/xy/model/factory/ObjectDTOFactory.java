package br.campos.xy.model.factory;

import br.campos.xy.model.abst.Document;
import br.campos.xy.model.abst.ObjectDTO;

/**
 * Fábrica de DTOs
 * 
 * @author Caio
 */
@FunctionalInterface
public interface ObjectDTOFactory {

	/**
	 * Cria um DTO a partir de um Documento
	 * 
	 * @param doc Documento Mongo
	 * @return
	 */
	ObjectDTO create(Document doc);
}
