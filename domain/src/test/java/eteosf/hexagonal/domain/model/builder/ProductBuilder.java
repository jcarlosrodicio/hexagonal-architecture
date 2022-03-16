package eteosf.hexagonal.domain.model.builder;

import eteosf.hexagonal.domain.model.Product;

public class ProductBuilder {

    public static Product toProductBuilder() {
        return Product.builder().productId(1).name("Product Name").description("Description of product").build();
    }
}
