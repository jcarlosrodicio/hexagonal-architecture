package eteosf.hexagonal.persistence.jpa.mapper;

import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.persistence.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toProductEntity(Product product);
}
