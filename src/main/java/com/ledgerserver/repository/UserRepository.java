package com.ledgerserver.repository;

import com.ledgerserver.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN  true ELSE false END FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    User findByUsername(String username);
}
