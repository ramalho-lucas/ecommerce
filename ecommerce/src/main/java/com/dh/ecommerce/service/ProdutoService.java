package com.dh.ecommerce.service;

import com.dh.ecommerce.dao.ProdutoDAO;
import com.dh.ecommerce.model.Produto;
import com.dh.ecommerce.model.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    public List<ProdutoDTO> buscar(){
        List<Produto> listProduto = produtoDAO.buscar(); //O produto DAO busca por um produto
        List<ProdutoDTO> listProdutoDTO = new ArrayList<>(); // Crio uma lista de produto DTO para conseguir converter/filtrar a lista de produto em produtoDTO

        ObjectMapper mapper = new ObjectMapper(); // utilizado para converter em DTO

        for (Produto produto : listProduto){
            listProdutoDTO.add(mapper.convertValue(produto, ProdutoDTO.class)); //convertendo um produto da lista em DTO e adicionando na lista produto DTO
        }
        //return produtoDAO.buscar();
        return listProdutoDTO; //Agora ela passa a retornar a lista de produto DTO
    }

    public ResponseEntity salvar(Produto produto){
        try {
            produto.setDataHoraCadastro(Timestamp.from(Instant.now())); //Toda vez que eu salvar um produto estou setando a data

            Produto produtoSalvo = produtoDAO.salvar(produto);
            return new ResponseEntity("Produto "+produtoSalvo.getNome()+" criado com sucesso!", HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity("Erro ao Cadastrar produto!",HttpStatus.BAD_REQUEST);
        }
    }


}
