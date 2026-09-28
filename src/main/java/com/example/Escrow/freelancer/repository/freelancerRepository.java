package com.example.Escrow.freelancer.repository;

import com.example.Escrow.freelancer.entity.freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface freelancerRepository
        extends JpaRepository<freelancer, Long> {

}