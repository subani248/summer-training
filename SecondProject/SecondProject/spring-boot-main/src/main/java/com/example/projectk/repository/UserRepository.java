package com.example.projectk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectk.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>
{
   Users findByUsername(String name);
}
