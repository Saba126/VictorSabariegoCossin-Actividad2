package mercatrans.model.collections;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)


@Document(collection="camiones")
public class Camion {
	
	public enum Estado {
	    ACTIVO,
	    INACTIVO
	}
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	
	private ObjectId conductorId;
	private String matricula;
	private String modelo;
	private int capacidadKg;
	private Estado estado;
}
