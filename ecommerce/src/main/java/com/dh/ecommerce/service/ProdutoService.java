package com.dh.ecommerce.service;

import com.dh.ecommerce.repositoryXdao.ProdutoRepository;
import com.dh.ecommerce.repositoryXdao.dao.ProdutoDAO;
import com.dh.ecommerce.entityXmodel.Produto;
import com.dh.ecommerce.entityXmodel.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    // ProdutoDAO produtoDAO = new ProdutoDAO();
    //ProdutoDAO produtoDAO;
    @Autowired
    ProdutoRepository repository;

    public List<ProdutoDTO> buscar(){
        //List<Produto> listProduto = produtoDAO.buscar(); //O produto DAO busca por um produto
        List<Produto> listProduto = repository.findAll();
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

            //Produto produtoSalvo = produtoDAO.salvar(produto);
            Produto produtoSalvo = repository.save(produto);
            return new ResponseEntity("Produto "+produtoSalvo.getNome()+" criado com sucesso!", HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity("Erro ao Cadastrar produto!",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deletar(Long id){
//      repository.findById(id).orElseThrow(() -> new RuntimeException());
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return new ResponseEntity("Id do produto não encontrado", HttpStatus.BAD_REQUEST);
        }

        repository.deleteById(id);
        return new ResponseEntity("Excluido com sucesso", HttpStatus.OK);
    }

    public ResponseEntity buscarPorSku(String numSKU) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Produto> produto = repository.findBysku(numSKU);
        if(produto.isEmpty()){
            return new ResponseEntity("Produto não encontrado", HttpStatus.BAD_REQUEST);
        }

        ProdutoDTO produtoDTO = mapper.convertValue(produto.get(), ProdutoDTO.class);

        return new ResponseEntity(produtoDTO,HttpStatus.OK);
    }
}
