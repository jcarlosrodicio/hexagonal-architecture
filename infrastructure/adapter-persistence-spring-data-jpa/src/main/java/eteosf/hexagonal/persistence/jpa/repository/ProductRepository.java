package eteosf.hexagonal.persistence.jpa.repository;

import eteosf.hexagonal.persistence.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByProductId(Integer productId);
}
