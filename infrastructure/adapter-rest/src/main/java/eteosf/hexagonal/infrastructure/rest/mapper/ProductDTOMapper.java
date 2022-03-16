package eteosf.hexagonal.infrastructure.rest.mapper;

import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.infrastructure.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    ProductDTO mapToProductDTO(Product product);

    Product mapToProduct(ProductDTO productDTO);

}
