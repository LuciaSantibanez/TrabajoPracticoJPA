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
@Table(name = "categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<Articulo>();


}
