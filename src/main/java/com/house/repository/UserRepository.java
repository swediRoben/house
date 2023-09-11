package com.house.repository;

import com.house.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT count(u) > 0 FROM UserEntity u  WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT C FROM users C WHERE C.username=:username and C.id!=:id", nativeQuery = true)
    Optional<UserEntity> verificationUsernname(@Param("id") Integer id, @Param("username") String username);


    @Query(value = "SELECT * FROM users WHERE username LIKE %?1%", nativeQuery = true)
    List<UserEntity> findByUsernameContaining(@Param("username") String username);

    UserEntity findByUsername(String username);

}