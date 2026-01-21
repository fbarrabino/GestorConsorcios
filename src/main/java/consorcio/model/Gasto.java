package consorcio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private Double monto;
    private LocalDate fechaGasto;
    private Boolean esExtraordinario;

    private LocalDateTime fechaModificacion;
}