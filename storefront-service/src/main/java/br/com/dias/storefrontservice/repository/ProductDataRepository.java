package br.com.dias.storefrontservice.repository;

import br.com.dias.storefrontservice.entity.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductData, UUID> {
    List<ProductData> findAllByEnabledIsTrue();

    List<ProductData> findAllByEnabledIsTrueAndSkuEquals(String sku);
}
