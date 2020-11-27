package com.fafram.webservice.repositories;

import com.fafram.webservice.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long>{
}
