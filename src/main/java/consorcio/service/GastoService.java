package consorcio.service;

import consorcio.model.Gasto;
import consorcio.repository.GastoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GastoService {

    private final GastoRepository gastoRepository;

    public GastoService(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    public Gasto guardarGasto(Gasto gasto) {
        validarGasto(gasto);
        return gastoRepository.save(gasto);
    }

    @Transactional
    public Gasto actualizarGasto(Integer id, Gasto gastoDetails) {
        validarGasto(gastoDetails);
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado con ID: " + id));
        
        gasto.setDescripcion(gastoDetails.getDescripcion());
        gasto.setMonto(gastoDetails.getMonto());
        gasto.setFechaGasto(gastoDetails.getFechaGasto());
        gasto.setEsExtraordinario(gastoDetails.getEsExtraordinario());
        gasto.setFechaModificacion(LocalDateTime.now());
        
        return gastoRepository.save(gasto);
    }

    @Transactional
    public void eliminarGastos(List<Integer> ids) {
        gastoRepository.deleteAllById(ids);
    }

    private void validarGasto(Gasto gasto) {
        if (gasto.getMonto() != null && gasto.getMonto() < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
    }
}