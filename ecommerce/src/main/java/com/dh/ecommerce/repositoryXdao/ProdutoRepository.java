package com.dh.ecommerce.repositoryXdao;

import com.dh.ecommerce.entityXmodel.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// extende jpa repository - como argumento precisa do nome da tabela (Produto) e o formato do id da tabela
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findBysku(String numSKU);

    Optional<Produto> findByskuAndNome(String numSKU, String nome);


    //HQL
    @Query("SELECT p FROM Produto p WHERE p.sku = :sku AND p.nome = :nome") //indica que tem que interpretar a query para entender o que a gente quer
    Optional<Produto> buscaPorSkuAndNome(@Param("sku") String numSKU,@Param("nome") String nome);
}
