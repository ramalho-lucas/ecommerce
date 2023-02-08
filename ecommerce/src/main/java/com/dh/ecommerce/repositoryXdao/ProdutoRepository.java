package com.dh.ecommerce.repositoryXdao;

import com.dh.ecommerce.entityXmodel.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// extende jpa repository - como argumento precisa do nome da tabela (Produto) e o formato do id da tabela
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findBysku(String numSKU);
}
