package com.dh.ecommerce.entityXmodel;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;
    @Column(nullable = false, length = 100)
    private String nome;
    private Double valor;
    private String lote;
    private  String categoria;
    private String fornecedor;

    @Column(name="data", nullable = false)
    private Timestamp dataHoraCadastro;

}
