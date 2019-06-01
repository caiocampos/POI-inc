package br.campos.xy.model.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.campos.xy.model.abst.ObjectDTO;
import br.campos.xy.model.document.POIDocument;
import br.campos.xy.util.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Caio
 */
@Data
@NoArgsConstructor
public class POIDTO extends ObjectDTO {
	private String name;
	private Double x;
	private Double y;

	public POIDTO(br.campos.xy.model.abst.Document doc) {
		POIDocument poi = (POIDocument) doc;
		this.name = poi.getName();
		this.x = poi.getX();
		this.y = poi.getY();
	}

	@JsonCreator
	public POIDTO(@JsonProperty("name") String name, @JsonProperty("x") Double x, @JsonProperty("y") Double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@JsonIgnore
	@Override
	public DataType getType() {
		return DataType.POI_TYPE;
	}
}
