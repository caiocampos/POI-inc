package br.campos.xy.model.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.util.Cartesian;
import br.campos.xy.util.DataType;
import lombok.Data;

/**
 * 
 * @author Caio
 */
@Data
@Document(collection = "poi")
public class POIDocument extends br.campos.xy.model.abst.Document implements Serializable {
	private static final long serialVersionUID = 2625585029360206149L;

	@Id
	private String id;

	@NonNull
	@Indexed(unique = true)
	private String name;
	
	@NonNull
	@GeoSpatialIndexed(max = Integer.MAX_VALUE, min = 0)
	private Double[] location;

	public POIDocument() {
		this.location = newPoint();
	}

	public POIDocument(br.campos.xy.model.abst.ObjectDTO dto) {
		POIDTO poi = (POIDTO) dto;
		this.location = newPoint();
		this.setLocation(poi.getX(), poi.getY());
		this.name = poi.getName();
	}

	public POIDocument(String name, Double x, Double y) {
		this.location = newPoint();
		this.setLocation(x, y);
		this.name = name;
	}

	@Override
	public DataType getType() {
		return DataType.POI_TYPE;
	}

	public void setLocation(Double x, Double y) {
		this.location[Cartesian.X.ordinal()] = x;
		this.location[Cartesian.Y.ordinal()] = y;
	}

	protected Double[] newPoint() {
		return new Double[2];
	}

	public Double getX() {
		return getLocation(Cartesian.X);
	}

	public Double getY() {
		return getLocation(Cartesian.Y);
	}

	private Double getLocation(Cartesian c) {
		try {
			return this.location[c.ordinal()];
		} catch (Exception e) {
			return 0D;
		}
	}
}
