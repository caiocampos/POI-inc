package br.campos.xy.model.abst;

/**
 * 
 * @author Caio
 */
@FunctionalInterface
public interface DocumentFactory {
	Document create(ObjectDTO dto);
}
