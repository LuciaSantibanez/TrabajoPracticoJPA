package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "numero")
    private int numero;

    @Column(name = "total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST) //se usa persist ya q solo queremos persistir un cliente al generar una factura, si borro factura no quiero q el cliente sea modificado
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();


}
