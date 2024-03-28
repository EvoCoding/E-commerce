package com.resul.ecommerce.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductReviewEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String reviewText;

    @CreationTimestamp
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
