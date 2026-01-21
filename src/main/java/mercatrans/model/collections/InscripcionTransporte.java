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

@Document(collection="inscripcion_transportes")
public class InscripcionTransporte {
	
	public enum Estado {
	    PENDIENTE,
	    ACEPTADA,
	    RECHAZADA
	    
	}
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	
	private ObjectId camionId;
	private ObjectId mercanciaId;
	private LocalDate fechaInscripcion;
	private Estado estado;
}
