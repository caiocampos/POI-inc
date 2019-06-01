package br.campos.xy.service.abst;

import java.util.List;

import br.campos.xy.model.document.POIDocument;
import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.util.XYException;

/**
 *
 * @author Caio
 */
public interface IPOIService {
	POIDocument create(POIDTO dto) throws XYException;

	POIDocument update(POIDTO dto) throws XYException;

	POIDocument find(POIDTO dto) throws XYException;

	List<POIDocument> find(Double x, Double y, Double distance) throws XYException;

	POIDTO findDTO(POIDTO dto) throws XYException;

	List<POIDTO> findDTO(Double x, Double y, Double distance) throws XYException;

	List<POIDTO> findDTO() throws XYException;

	void delete(POIDTO dto) throws XYException;

	void deleteAll() throws XYException;
}
