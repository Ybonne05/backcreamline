package com.cream.co.backcreamline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cream.co.backcreamline.Model.Order;

public interface OrderRepository extends JpaRepository <Order, Long> {

}
