package eteosf.hexagonal.application.service.adapter;

import eteosf.hexagonal.application.service.api.ProductService;
import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductServiceAdapter implements ProductService {

    private final ProductPersistencePort productPersistencePort;

    @Override
    public void addProduct(Product product) {
        productPersistencePort.addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        productPersistencePort.removeProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productPersistencePort.getProducts();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productPersistencePort.getProductById(productId);
    }
}
