package com.teste.aula_1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.aula_1.models.Product;
import com.teste.aula_1.models.excepion.ResourceNotFoundException;

@Repository
public class ProductRepositoryOld {

    private List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    /**
     * metodo de retorno de produtos
     * 
     * @return lista de produtos
     */

    public List<Product> getAll() {
        return products;

    }

    /**
     * metodo para retornar produto pelo numero de id
     * 
     * @param id do produto que sera localizado
     * @return um produto caso tenha encontrado
     */
    public Optional<Product> getForId(Integer id) {
        return products
                .stream()
                .filter(products -> products.getId() == id)
                .findFirst();

    }

    /**
     * metodo para adicionar produtos no simulador de banco de dados
     * 
     * @param product que será adicionado
     * @return retorna o produto que foi adicionado na lista
     */
    public Product saveProduct(Product product) {
        lastId++;

        product.setId(lastId);
        products.add(product);

        return product;
    }

    /**
     * metodo para remover produto por ID
     * 
     * @param id do produto a ser deletado
     */
    public void delete(Integer id) {
        products.removeIf(product -> product.getId() == id);
    }

    /**
     * metodo para atualizar o produto na lista
     * 
     * @param product que vai ser atualizado
     * @return produto depois já atualizado
     */
    public Product atualize(Product product) {

        // encontrar produto na lista
        Optional<Product> foundProduct = getForId(product.getId());

        if (foundProduct.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }

        // remover o produto antigo da lista
        delete(product.getId());

        // depois adicionar o novo atualizado

        products.add(product);

        return product;

    }

}
