package com.dh.ecommerce.entityXmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Timestamp dataEntrega;

    //@ManyToOne
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_join")
    private Endereco endereco;


    // @OneToMany
    //private List<Endereco> listEndereco;

    @ManyToMany
    @JoinTable(name = "pedido-produto",
                joinColumns = @JoinColumn(name = "pedido"),
                inverseJoinColumns = @JoinColumn(name = "produto"))
    private List<Produto> produto;
}
