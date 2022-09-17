package com.coderscampus.gamereviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.gamereviews.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
