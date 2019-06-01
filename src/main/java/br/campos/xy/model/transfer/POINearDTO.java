package br.campos.xy.model.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Caio
 */
@Data
@NoArgsConstructor
public class POINearDTO {
	Double x;
	Double y;
	Double distance;

	@JsonCreator
	public POINearDTO(@JsonProperty("x") Double x, @JsonProperty("y") Double y,
			@JsonProperty("distance") Double distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
