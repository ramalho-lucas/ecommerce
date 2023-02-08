package com.dh.ecommerce.controller;

import com.dh.ecommerce.model.Produto;
import com.dh.ecommerce.model.dto.ProdutoDTO;
import com.dh.ecommerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    ProdutoService service = new ProdutoService();

    @GetMapping("/buscar1/{numPedido}/{nomeUsuario}")
    public String buscar1(@PathVariable int numPedido, @PathVariable String nomeUsuario) {

        return "Batendo no GET ------- Numero Pedido: " + numPedido + " -- Nome Usuario: " + nomeUsuario;
    }

    @GetMapping("/buscar2")
    public String buscar2(@RequestParam("numPedido") int numPedido,
                          @RequestParam("nomeUsuario") String nomeUsuario) {

        return "Batendo no GET ------- Numero Pedido: " + numPedido + " -- Nome Usuario: " + nomeUsuario;
    }

    @GetMapping()
    public List<ProdutoDTO> buscarProduto(){
        return service.buscar();
    }

//    @PostMapping()
//    public Produto salvar(@RequestBody Produto produto) {
//        return service.salvar(produto);
//    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Produto produto){
        return service.salvar(produto);
    }

    @DeleteMapping()
    public String deletar() {
        return "Entrou no deletar";
    }


    @PutMapping()
    public String alteracaoTotal() {
        return "Entrou no put";
    }

    @PatchMapping()
    public String alteracaoParcial(){
        return "Entrou no patch";
    }


}
