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


@Document(collection="mercancias")
public class Mercancia {
	
	public enum Estado {
	    PENDIENTE,
	    ASIGNADA,
	    ENTREGADA
	    
	}
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	
	private String descripcion;
	private String origen;
	private String destino;
	private int pesoKg;
	private LocalDate fechaEntregaEstimada;
	private Estado estado;
}
