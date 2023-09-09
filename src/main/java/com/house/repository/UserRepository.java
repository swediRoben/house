package com.house.repository;

import com.house.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT count(u) > 0 FROM UserEntity u  WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT u.password FROM users u  WHERE u.username = :username", nativeQuery = true)
    String  existsByPasswordByUsername(@Param("username") String username);
//    @Query("SELECT count(u) > 0 FROM UserEntity u  WHERE u.username = :username AND u.password=: password")
//    boolean existsByPasswordAndUsername(@Param("username") String username, @Param("password") String password);
    @Query("SELECT u.password FROM UserEntity u  WHERE u.username = :username")
    String getPasswordByUsername(@Param("username") String username);
    UserEntity findByUsername(String username); 
    
}