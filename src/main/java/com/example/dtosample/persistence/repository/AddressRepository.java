package com.example.dtosample.persistence.repository;

import com.example.dtosample.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
