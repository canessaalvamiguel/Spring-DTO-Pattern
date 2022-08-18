package com.example.dtosample.demo.persistence.projections;

import org.springframework.beans.factory.annotation.Value;

//open projection sample
public interface PersonFullLocation {
    @Value("#{target.name + ' ' + target.phoneNumber + ' ' + target.street}")
    String getFullLocation();
}
