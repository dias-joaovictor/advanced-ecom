package br.com.dias.paymentservice.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class EcommerceEntity {

    @CreationTimestamp
    @Immutable
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
