package mercatrans.model.service;

import java.util.List;
import mercatrans.model.collections.Mercancia;
import mercatrans.model.collections.Mercancia.Estado;

public interface MercanciaService {

	List<Mercancia> findByEstado(Estado estado);
}
