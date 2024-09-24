package br.com.dias.storefrontservice.repository;

import br.com.dias.storefrontservice.entity.ProductDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductDataEntity, UUID> {
    List<ProductDataEntity> findAllByEnabledIsTrue();

    List<ProductDataEntity> findAllByEnabledIsTrueAndSkuEquals(String sku);

    Set<ProductDataEntity> findAllByEnabledIsTrueAndSkuIn(Set<String> sku);
}
