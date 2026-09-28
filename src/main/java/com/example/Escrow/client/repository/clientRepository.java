package com.example.Escrow.client.repository;

import com.example.Escrow.client.entity.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<client, Long> {

}