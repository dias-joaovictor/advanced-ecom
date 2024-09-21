package br.com.dias.productfeedservice.entity;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(nullable = false, length = 13)
    private String sku;

    private String description;

    private BigDecimal price;

}
