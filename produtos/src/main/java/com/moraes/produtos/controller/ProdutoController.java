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
    private ProdutoService livroService;

    @PostMapping
    public ProdutoModel criarLivro(@RequestBody ProdutoModel livroModel){
        return livroService.criarProduto(livroModel);
    }

    @GetMapping
    public List<ProdutoModel> listarLivros(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarLivro(@PathVariable  Long id){
        return livroService.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarProduto(id);
    }

}
