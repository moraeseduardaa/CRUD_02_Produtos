package com.moraes.produtos.controller;

import com.moraes.produtos.model.ProdutoModel;
import com.moraes.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){

        ProdutoModel request = produtoService.criarProduto(produtoModel);

        URI uri = URI.create("/produtos/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarProduto(@PathVariable  Long id){
        return produtoService.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
