package com.coderscampus.gamereviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.gamereviews.domain.Authorities;

public interface RoleRepository extends JpaRepository<Authorities, Long>{

}
