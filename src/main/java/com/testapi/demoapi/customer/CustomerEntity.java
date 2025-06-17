package com.testapi.demoapi.customer;

import com.testapi.demoapi.invoice.InvoiceEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceEntity> invoices;
    @CreationTimestamp
    @Column(name = "create_at")
    private Instant createAt;
    @UpdateTimestamp
    @Column(name = "update_at")
    private Instant updateAt;

}