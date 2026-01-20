package consorcio.service;

import consorcio.model.Gasto;
import consorcio.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GastoService {
    
    private final GastoRepository gastoRepository;

    public GastoService(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    public Gasto guardarGasto(Gasto gasto) {
        if (gasto.getMonto() != null && gasto.getMonto().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        return gastoRepository.save(gasto);
    }

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }
}
