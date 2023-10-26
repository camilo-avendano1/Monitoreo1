package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VIAJE")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIAJE_id_gen")
    @SequenceGenerator(name = "VIAJE_id_gen", sequenceName = "ID_VIAJE_SECUENCIA", allocationSize = 1)
    @Column(name = "ID_VIAJE", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ID_CONDUCTOR", nullable = false)
    private Long idConductor;

    @NotNull
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @NotNull
    @Column(name = "ID_UBICACION_INICIAL", nullable = false)
    private Integer idUbicacionInicial;

    @NotNull
    @Column(name = "ID_UBICACION_FINAL", nullable = false)
    private Integer idUbicacionFinal;

}