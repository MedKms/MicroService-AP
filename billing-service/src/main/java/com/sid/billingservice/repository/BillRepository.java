package com.sid.billingservice.repository;

import com.sid.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
}
