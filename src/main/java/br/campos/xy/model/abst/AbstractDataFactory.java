package br.campos.xy.model.abst;

import br.campos.xy.model.document.POIDocument;
import br.campos.xy.model.transfer.POIDTO;

public abstract class AbstractDataFactory {

	public static DocumentFactory getFactory(ObjectDTO dto) {
		switch (dto.getType()) {
		case POI_TYPE:
			return POIDocument::new;
		default:
			return null;
		}
	}

	public static ObjectDTOFactory getFactory(Document doc) {
		switch (doc.getType()) {
		case POI_TYPE:
			return POIDTO::new;
		default:
			return null;
		}
	}
}
