package mercatrans.model.service;

import java.util.List;
import mercatrans.model.collections.Mercancia;
import mercatrans.model.collections.Mercancia.Estado;

public interface MercanciaService {
	List<Mercancia> findByEstadoEquals(Estado estado);
	List<Mercancia> obatainPendientes();
	List<Mercancia> findByOrigenOrDestinoOrPeso(String origen, String destino, int peso);
	boolean isValidInteger(String str);
	//List<Mercancia> findByConductorId(Estado estado);
}
