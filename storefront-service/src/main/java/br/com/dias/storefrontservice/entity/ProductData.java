package br.com.dias.storefrontservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString(of = {"id", "sku", "description", "price"})
public class ProductData extends EcommerceEntity {

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
