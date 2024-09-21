package br.com.dias.productfeedservice.repository;

import br.com.dias.productfeedservice.entity.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductData, UUID> {
}
