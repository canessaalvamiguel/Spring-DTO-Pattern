package com.example.dtosample.persistence.repository;

import com.example.dtosample.persistence.entity.Person;
import com.example.dtosample.persistence.projections.PersonFullLocation;
import com.example.dtosample.persistence.projections.PersonLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;

public interface PersonRepository extends JpaRepository<Person, Long> {

    //using close interface projection
    @Query(value = "SELECT " +
            "P.NAME as name, " +
            "P.PHONE_NUMBER as phoneNumber, " +
            "A.STREET as street " +
            "FROM PERSON P " +
            "INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            "WHERE P.id = :id ", nativeQuery = true)
    public PersonLocation getPersonLocation(@Param("id") Long personId);

    //using open interface projection
    @Query(value = "SELECT " +
            "P.NAME as name, " +
            "P.PHONE_NUMBER as phoneNumber, " +
            "A.STREET as street " +
            "FROM PERSON P " +
            "INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            "WHERE P.id = :id ", nativeQuery = true)
    public PersonFullLocation getPersonFullLocation(@Param("id") Long personId);

    //using class based projection
    @Query(value = "SELECT " +
            "P.NAME as name, " +
            "P.PHONE_NUMBER as phoneNumber, " +
            "A.STREET as street " +
            "FROM PERSON P " +
            "INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            "WHERE P.id = :id ", nativeQuery = true)
    public Tuple getPersonLocationDTO(@Param("id") Long personId);
}
