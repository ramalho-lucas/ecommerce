package com.dh.ecommerce.repositoryXdao.dao;

import com.dh.ecommerce.entityXmodel.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// O DAO é substituido pelo repository
@Repository
public class ProdutoDAO {
//    public static List<Produto> listProduto = Arrays.asList(new Produto("Camiseta",15.0),
//                                                    new Produto("Calca",25.50)
//    );

    public static List<Produto> listProduto = new ArrayList<>();

    public List<Produto> buscar(){
        return listProduto;
    }

    public Produto salvar(Produto produto){
        listProduto.add(produto);
        return produto;
    }
}
