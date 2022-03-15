package eteosf.hexagonal.infrastructure.rest.mapper;

import com.zara.price.model.ProductDTO;
import eteosf.hexagonal.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    ProductDTO mapToProductDTO(Product product);

    Product mapToProduct(ProductDTO productDTO);

}
