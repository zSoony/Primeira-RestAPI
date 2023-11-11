package com.teste.aula_1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.aula_1.models.Product;
import com.teste.aula_1.services.ProducService;

@RestController
@RequestMapping("/api/product")
public class ProductCOntroller {

    @Autowired
    private ProducService producService;

    @GetMapping
    public List<Product> gatAll() {
        return producService.getAll();

    }

    @PostMapping
    public Product addidct(@RequestBody Product product) {
        return producService.addict(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getFotId(@PathVariable Integer id) {
        return producService.getForId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        producService.delete(id);
        return "produto com id: " + id + " foi deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Product atualize(@RequestBody Product product, @PathVariable Integer id) {
        return producService.atualize(id, product);

    }

}