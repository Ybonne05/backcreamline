package com.cream.co.backcreamline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cream.co.backcreamline.Model.UserAuth;


public interface UserAuthRepository extends JpaRepository <UserAuth, Long> {
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
