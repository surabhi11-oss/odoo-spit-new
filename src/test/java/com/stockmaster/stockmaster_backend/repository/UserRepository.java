package com.stockmaster.stockmaster_backend.repository;

import com.stockmaster.stockmaster_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
