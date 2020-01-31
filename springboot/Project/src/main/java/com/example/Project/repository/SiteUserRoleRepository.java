package com.example.Project.repository;

import com.example.Project.domain.entities.SiteUserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SiteUserRepository
 */
@Repository
public interface SiteUserRoleRepository extends JpaRepository<SiteUserRole, Integer> {

}