package eteosf.hexagonal.infrastructure.rest.controller;

import com.zara.price.api.ProductApi;
import com.zara.price.model.ProductDTO;
import com.zara.price.model.ProductsDTO;
import eteosf.hexagonal.application.service.api.ProductService;
import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.infrastructure.rest.mapper.ProductDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductDTOMapper mapper;

    @Override
    public ResponseEntity<ProductsDTO> getProducts() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProducts(service.getProducts()
                .stream().map(mapper::mapToProductDTO).collect(Collectors.toList()));
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addProduct(ProductDTO productDTO) {
        service.addProduct(mapper.mapToProduct(productDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeProduct(ProductDTO productDTO) {
        service.removeProduct(mapper.mapToProduct(productDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(Integer productId) {
        return new ResponseEntity<>(
                mapper.mapToProductDTO(service.getProductById(productId)), HttpStatus.OK);
    }
}
