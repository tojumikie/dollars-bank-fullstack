package com.dollarsbank2.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dollarsbank2.springboot.model.Role;
import com.dollarsbank2.springboot.model.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleEnum name);
}
