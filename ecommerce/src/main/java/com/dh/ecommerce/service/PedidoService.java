package com.dh.ecommerce.service;

import com.dh.ecommerce.entityXmodel.Pedido;
import com.dh.ecommerce.repositoryXdao.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    public ResponseEntity salvar(Pedido pedido) {
        try {
            Pedido pedidoSalvo = repository.save(pedido);
            return new ResponseEntity(pedidoSalvo, HttpStatus.CREATED) ;
        } catch (Exception e){
            return new ResponseEntity("Nçao foi possivel salvar o pedido", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity buscarTodos() {
        List<Pedido> listPedidos = repository.findAll();

        if(listPedidos.isEmpty()){
            return new ResponseEntity("Nenhum pedido cadastrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(listPedidos, HttpStatus.OK);
    }
}
