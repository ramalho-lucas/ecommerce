package com.dh.ecommerce.controller;

import com.dh.ecommerce.entityXmodel.Produto;
import com.dh.ecommerce.entityXmodel.dto.ProdutoDTO;
import com.dh.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    // ProdutoService service = new ProdutoService(); Gera dependencia
    @Autowired
    ProdutoService service; //Realizando a injeção de dependencia, pedindo pro java criar a instancia, agora o produto service precisa ser um bean (@Service)


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


    @GetMapping("/buscarSKU/{numSKU}")
    public ResponseEntity buscarSKU(@PathVariable String numSKU){
        return service.buscarPorSku(numSKU);
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
    public ResponseEntity deletar(@RequestParam("id") Long id) {
        return service.deletar(id);
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
