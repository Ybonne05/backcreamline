package com.cream.co.backcreamline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cream.co.backcreamline.Model.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
