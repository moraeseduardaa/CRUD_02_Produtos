package com.moraes.produtos.controller;

import com.moraes.produtos.model.ProdutoModel;
import com.moraes.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criarproduto(@RequestBody ProdutoModel produtoModel){
        return produtoService.criarProduto(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarProduto(@PathVariable  Long id){
        return produtoService.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }

}
