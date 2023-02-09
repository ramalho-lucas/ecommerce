package com.dh.ecommerce.entityXmodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Column(nullable = false, unique = true)   //O que esta no @Column são validacoes do Banco
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
