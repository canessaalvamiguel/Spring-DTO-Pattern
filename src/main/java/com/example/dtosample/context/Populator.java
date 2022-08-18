package com.example.dtosample.context;

import com.example.dtosample.persistence.entity.Address;
import com.example.dtosample.persistence.entity.Person;
import com.example.dtosample.persistence.repository.AddressRepository;
import com.example.dtosample.persistence.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Populator implements InitializingBean {

    private AddressRepository addressRepository;
    private PersonRepository personRepository;

    public Populator(AddressRepository addressRepository, PersonRepository personRepository) {
        super();
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" ===> Populating DB using mock data");
        populate();
        log.info(" ===> Populating completed");
    }

    public void populate(){
        for (int i = 0; i < 10; i++) {
            Address address = this.addressRepository.save(getRamdomAddress(i));
            Person person = getRamdomPerson(i);
            person.setAddressId(address.getId());
            this.personRepository.save(person);
        }
    }

    private Address getRamdomAddress(int i){
        Address address = new Address();
        address.setStreet("Street " + i);
        address.setCity("City " + i);
        address.setState("State " + i);
        address.setPostalCode(i);
        address.setCountry("Country " + i);
        return address;
    }

    private Person getRamdomPerson(int i){
        Person person = new Person();
        person.setName("Name " + i);
        person.setEmail("Email " + i);
        person.setPhoneNumber("55511545" + i);
        return person;
    }
}
