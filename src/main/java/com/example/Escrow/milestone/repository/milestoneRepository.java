package com.example.Escrow.milestone.repository;

import com.example.Escrow.milestone.entity.milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface milestoneRepository extends JpaRepository<milestone, Long> {

}