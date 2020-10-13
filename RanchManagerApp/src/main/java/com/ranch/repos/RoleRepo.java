package com.ranch.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.Roles;
import com.ranch.model.enums.EnumRoles;

@CrossOrigin()
@Repository
public interface RoleRepo extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(EnumRoles name);
}