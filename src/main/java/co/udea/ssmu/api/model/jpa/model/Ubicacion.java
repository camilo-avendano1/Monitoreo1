package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "UBICACION")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UBICACION_id_gen")
    @SequenceGenerator(name = "UBICACION_id_gen", sequenceName = "ID_UBICACION_SECUENCIA", allocationSize = 1)
    @Column(name = "ID_UBICACION", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "LATITUD", nullable = false, precision = 9, scale = 6)
    private BigDecimal latitud;

    @NotNull
    @Column(name = "LONGITUD", nullable = false, precision = 9, scale = 6)
    private BigDecimal longitud;

}