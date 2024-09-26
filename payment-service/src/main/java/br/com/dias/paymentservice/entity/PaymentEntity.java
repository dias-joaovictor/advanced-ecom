package br.com.dias.paymentservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "Payment")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PaymentEntity extends EcommerceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(nullable = false)
    @JdbcTypeCode(Types.CHAR)
    private UUID orderId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 50)
    private String paymentProviderHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
