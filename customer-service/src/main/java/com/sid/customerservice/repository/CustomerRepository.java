package com.sid.customerservice.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200") // or @CrossOrigin("*")
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
