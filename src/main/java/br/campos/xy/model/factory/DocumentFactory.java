package br.campos.xy.model.factory;

import br.campos.xy.model.abst.Document;
import br.campos.xy.model.abst.ObjectDTO;

/**
 * Fábrica de Documentos Mongo
 * 
 * @author Caio
 */
@FunctionalInterface
public interface DocumentFactory {

	/**
	 * Cria um Documento a partir de um DTO
	 * 
	 * @param dto DTO
	 * @return
	 */
	Document create(ObjectDTO dto);
}
