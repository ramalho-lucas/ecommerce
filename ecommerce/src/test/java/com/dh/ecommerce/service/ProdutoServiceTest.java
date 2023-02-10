package com.dh.ecommerce.service;

import com.dh.ecommerce.entityXmodel.Produto;
import com.dh.ecommerce.repositoryXdao.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProdutoServiceTest {

    @Autowired
    ProdutoService service;
    ProdutoRepository repository;

    @Test
    void salvar(){
        Produto produto = new Produto();
        produto.setCategoria("Vestuario");
        produto.setNome("Meia");
        produto.setFornecedor("Bras");
        produto.setLote("988-FFA");
        produto.setValor(30.55);
        produto.setSku("889878");


        ResponseEntity produtoSalvo = service.salvar(produto);


        System.out.println(produtoSalvo.getStatusCode());
        Assertions.assertEquals(produtoSalvo.getStatusCode(), HttpStatus.CREATED);

    }
}
