package com.dh.ecommerce.entityXmodel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoDTO {
    private String nome;
    private String sku;
    private Double valor;
    //@JsonIgnore
    private String lote;
   // @JsonIgnore
    private String categoria;
    private String fornecedor;

    private Timestamp dataHoraCadastro;
    private LocalDate dataCadastro;
    private LocalTime horaCadastro;

    public LocalDate getDataCadastro(){
        return dataHoraCadastro.toLocalDateTime().toLocalDate();
    }

    public LocalTime gethoraCadastro(){
        return dataHoraCadastro.toLocalDateTime().toLocalTime();
    }

}
