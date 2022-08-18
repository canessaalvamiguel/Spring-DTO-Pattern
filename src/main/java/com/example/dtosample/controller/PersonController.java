package com.example.dtosample.controller;

import com.example.dtosample.persistence.projections.PersonFullLocation;
import com.example.dtosample.persistence.projections.PersonLocation;
import com.example.dtosample.persistence.projections.PersonLocationDTO;
import com.example.dtosample.persistence.projections.PersonLocationDTO2;
import com.example.dtosample.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Tuple;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/interface_open")
    public PersonFullLocation getSampleInterfaceOpenProjection() {
        return personRepository.getPersonFullLocation(2L);
    }

    @GetMapping("/interface_closed")
    public PersonLocation getSampleInterfaceClosedProjection() {
        return personRepository.getPersonLocation(4L);
    }

    @GetMapping("/class_based")
    public PersonLocationDTO getSampleClassBasedProjection() {
        Tuple t = personRepository.getPersonLocationDTO(6L);
        return new PersonLocationDTO(
                t.get(0, String.class),
                t.get(1, String.class),
                t.get(2, String.class)
        );
    }

    @GetMapping("/class_based_named_query")
    public PersonLocationDTO2 getSampleClassBasedNamedQueryProjection() {
        return personRepository.getPersonLocationDTO2(2L);
    }

    @GetMapping("/dynamically")
    public Object getSampleClassBasedDynamicallyProjection() {
        return personRepository.getPersonLocationDynamically(2L, PersonLocation.class);
        //return personRepository.getPersonLocationDynamically(2L, PersonFullLocation.class);
    }
}
