package eteosf.hexagonal.persistence.jpa.adapter;

import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import eteosf.hexagonal.persistence.jpa.mapper.ProductMapper;
import eteosf.hexagonal.persistence.jpa.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductSpringJpaAdapter implements ProductPersistencePort {

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    @Override
    public void addProduct(Product product) {
        productRepository.save(mapper.toProductEntity(product));
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.delete(mapper.toProductEntity(product));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(mapper::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Integer productId) {
        return mapper.toProduct(productRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("The product  not exist")));
    }
}
