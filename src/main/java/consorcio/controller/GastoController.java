package consorcio.controller;

import consorcio.model.Gasto;
import consorcio.service.GastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Gasto gasto) {
        try {
            return ResponseEntity.ok(gastoService.guardarGasto(gasto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Gasto gasto) {
        try {
            return ResponseEntity.ok(gastoService.actualizarGasto(id, gasto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> eliminarMasivo(@RequestBody List<Integer> ids) {
        gastoService.eliminarGastos(ids);
        return ResponseEntity.noContent().build();
    }
}
