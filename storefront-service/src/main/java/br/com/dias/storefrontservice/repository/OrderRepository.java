package br.com.dias.storefrontservice.repository;

import br.com.dias.storefrontservice.entity.OrderEntity;
import br.com.dias.storefrontservice.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findAllByOrderStatus(Status orderStatus);
}
