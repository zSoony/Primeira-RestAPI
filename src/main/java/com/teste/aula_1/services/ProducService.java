package com.teste.aula_1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.aula_1.models.Product;
import com.teste.aula_1.models.excepion.ResourceNotFoundException;
import com.teste.aula_1.repository.ProductRepository;
import com.teste.aula_1.shared.ProductDTO;

@Service
public class ProducService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * metodo para obter lista de todos os produtos
     * 
     * @return lista de todos os produtos
     */
    public List<ProductDTO> getAll() {

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ModelMapper().map(product, ProductDTO.class))
                .collect(Collectors.toList());

    }

    /**
     * metodo para obter objeto por id
     * 
     * @param id do objeto
     * @return o objeto com id correspondente
     */
    public Optional<ProductDTO> getForId(Integer id) {
        // Obtendo produto pelo id
        Optional<Product> product = productRepository.findById(id);

        // checando se o id e validocaso não seja lança exeption
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Produto com ID: " + id + "não encontrado");

        }
        // convertendo o optional em dto
        ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);
        // criando e retornando optional de dto
        return Optional.of(dto);

    }

    /**
     * metodo para adicionar objeto
     * 
     * @param product que sera adicionado
     * @return produto adicionado
     *         /*
     */
    public ProductDTO addict(ProductDTO productDto) {
        // removendo id para castro
        productDto.setId(null);

        // criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        // converter o ProdutoDTO em um Produto
        Product product = mapper.map(productDto, Product.class);

        // Salvat o Produto no banco
        product = productRepository.save(product);
        productDto.setId(product.getId());

        // Retornar o ProdutoDTO atualizado
        return productDto;
    }

    public void delete(Integer id) {
        // verificar se existe
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            // se não existir lança exceção e aviso
            throw new ResourceNotFoundException(
                    "Não foi possivel deletar o produto com id: " + id + " produto não existe");
        }
        // caso exista deleta o produto com o respectivo id
        productRepository.deleteById(id);
    }

    public ProductDTO atualize(Integer id, ProductDTO productDto) {
        // Passar o id para o produto dto
        productDto.setId(id);

        // Criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        // Converter o DTO em Produto
        Product product = mapper.map(productDto, Product.class);

        // Atualizar no banco de dad
        return productDto;
    }

}
