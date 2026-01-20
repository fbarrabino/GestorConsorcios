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

    @PostMapping
    public ResponseEntity<Gasto> guardar(@RequestBody Gasto gasto) {
        Gasto gastoGuardado = gastoService.guardarGasto(gasto);
        return ResponseEntity.ok(gastoGuardado);
    }

    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listarTodos();
    }
}
