package com.testapi.demoapi.invoice;

import com.testapi.demoapi.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_amount", nullable = false)
    private String totalAmount;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private CustomerEntity customer;
    @CreationTimestamp
    @Column(name = "create_at")
    private Instant createAt;
    @UpdateTimestamp
    @Column(name = "update_at")
    private Instant updateAt;

}