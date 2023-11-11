package com.teste.aula_1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.aula_1.models.Product;
import com.teste.aula_1.repository.ProductRepositoryOld;

@Service
public class ProducService {

    @Autowired
    private ProductRepositoryOld productRepository;

    /**
     * metodo para obter lista de todos os produtos
     * 
     * @return lista de todos os produtos
     */
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    /**
     * metodo para obter objeto por id
     * 
     * @param id do objeto
     * @return o objeto com id correspondente
     */
    public Optional<Product> getForId(Integer id) {
        // inserir regra de validação aqui

        return productRepository.getForId(id);
    }

    /**
     * metodo para adicionar objeto
     * 
     * @param product que sera adicionado
     * @return produto adicionado
     *         /*
     */
    public Product addict(Product product) {
        // regras de filtro ou validações aqui

        return productRepository.addict(product);
    }

    public void delete(Integer id) {
        // regra para validação inserida aqui
        productRepository.delete(id);
    }

    public Product atualize(Integer id, Product product) {
        // ter alguma validação no id

        product.setId(id);
        return productRepository.atualize(product);

    }

}
