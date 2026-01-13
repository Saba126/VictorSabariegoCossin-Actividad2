package mercatrans.model.collections;

import java.time.LocalDate;

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
@Builder(toBuilder=true)

@Document(collection="incidencias")
public class Incidencia {
	
	public enum Tipo {
	    MERCANCIA,
	    METEOROLOGIA,
	    DOCUMENTA,
	}
	
	public enum Estado{
		ABIERTA,
		RESUELTA,
	}
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	
	private Camion camionId;
	private String descripcion;
	private LocalDate fecha;
	private Mercancia mercanciaId;
	private Tipo tipo;
	private Estado estado;
}
