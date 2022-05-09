package com.hr.springboot.oauth2.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.springboot.oauth2.authserver.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User getByEmail(final String email);
}
