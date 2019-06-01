package br.campos.xy.model.abst;

/**
 * 
 * @author Caio
 */
@FunctionalInterface
public interface ObjectDTOFactory {
	ObjectDTO create(Document doc);
}
