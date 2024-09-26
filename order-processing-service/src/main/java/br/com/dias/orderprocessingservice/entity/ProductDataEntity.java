package br.com.dias.orderprocessingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "ProductData")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString(of = {"id", "sku", "description", "price"})
public class ProductDataEntity extends EcommerceEntity {

    @Id
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(nullable = false, length = 13)
    private String sku;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private int quantity;

}
