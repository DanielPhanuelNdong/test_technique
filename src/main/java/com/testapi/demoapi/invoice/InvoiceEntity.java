package com.testapi.demoapi.invoice;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

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
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity billingAddress;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceItemsEntity> invoiceItems;

    @CreationTimestamp
    @Column(name = "create_at")
    private Instant createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Instant updateAt;

}