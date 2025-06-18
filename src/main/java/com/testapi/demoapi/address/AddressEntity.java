package com.testapi.demoapi.address;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    private String zipCode;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CustomerEntity> customers;

    @OneToMany(mappedBy = "billingAddress", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<InvoiceEntity> invoices;

    @CreationTimestamp
    @Column(name = "create_at")
    private Instant createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Instant updateAt;
}
