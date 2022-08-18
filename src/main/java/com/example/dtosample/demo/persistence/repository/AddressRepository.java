package com.example.dtosample.demo.persistence.repository;

import com.example.dtosample.demo.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
