package com.dh.ecommerce.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private Double valor;
    private String lote;
    private  String categoria;
    private String fornecedor;

    private Timestamp dataHoraCadastro;

}
