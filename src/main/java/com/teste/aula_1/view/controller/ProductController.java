package com.teste.aula_1.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.aula_1.services.ProducService;
import com.teste.aula_1.shared.ProductDTO;
import com.teste.aula_1.view.model.ProductRequest;
import com.teste.aula_1.view.model.ProductResponse;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProducService producService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> gatAll() {
        List<ProductDTO> products = producService.getAll();

        ModelMapper mapper = new ModelMapper();

        List<ProductResponse> response = products.stream()
                .map(productDto -> mapper.map(productDto, ProductResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addidct(@RequestBody ProductRequest productReq) {

        ModelMapper mapper = new ModelMapper();
        ProductDTO productDto = mapper.map(productReq, ProductDTO.class);

        productDto = producService.addict(productDto);
        return new ResponseEntity<>(mapper.map(productDto, ProductResponse.class), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> getFotId(@PathVariable Integer id) {

        Optional<ProductDTO> dto = producService.getForId(id);
        ProductResponse product = new ModelMapper().map(dto.get(), ProductResponse.class);

        return new ResponseEntity<>(Optional.of(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        producService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> atualize(@RequestBody ProductRequest productReq, @PathVariable Integer id) {

        ModelMapper mapper = new ModelMapper();
        ProductDTO productDto = mapper.map(productReq, ProductDTO.class);

        return new ResponseEntity<>(
                mapper.map(productDto, ProductResponse.class),
                HttpStatus.OK);

    }

}