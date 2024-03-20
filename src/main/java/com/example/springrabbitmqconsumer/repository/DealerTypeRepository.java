package com.example.springrabbitmqconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springrabbitmqconsumer.entity.DealerType;

@Repository
public interface DealerTypeRepository extends JpaRepository<DealerType, Long> {

}
