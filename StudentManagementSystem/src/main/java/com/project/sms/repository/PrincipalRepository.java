package com.project.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.entity.Principal;

@Repository
public interface PrincipalRepository extends JpaRepository<Principal, Integer> {

}
