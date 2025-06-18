package com.testapi.demoapi.address.repository;

import com.testapi.demoapi.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
