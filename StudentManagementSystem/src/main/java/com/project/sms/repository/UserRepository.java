package com.project.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sms.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT DISTINCT user FROM User user " +
	            "INNER JOIN FETCH user.authorities AS authorities " +
	            "WHERE user.username = :username")
	User findByUsername(@Param("username") String username);
	 //Optional<User> findByUsername(String username);
}
