package com.example.Project.repository;

import com.example.Project.domain.entities.SiteRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SiteRoleRepository
 */
@Repository
public interface SiteRoleRepository extends JpaRepository<SiteRole, String> {

} 