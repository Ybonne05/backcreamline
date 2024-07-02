package com.cream.co.backcreamline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cream.co.backcreamline.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long> {

}
