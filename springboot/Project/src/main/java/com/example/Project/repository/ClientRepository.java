package com.example.Project.repository;

import java.util.List;

import com.example.Project.domain.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(nativeQuery = true, value = "select distinct name from Client")
    List<String> listDistinct();

    
    List<Client> findByPhone(String phone);

    List<Client> findByPhoneOrderByName(String phone);

    List<Client> findByPhoneContainingOrderByName(String phone);
}