package br.com.dias.orderprocessingservice.repository;

import br.com.dias.orderprocessingservice.entity.OrderEntity;
import br.com.dias.orderprocessingservice.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findAllByOrderStatusNot(Status status);
}
