package com.example.banking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{
   User findByUsername(String username);
}
