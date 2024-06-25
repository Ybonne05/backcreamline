package com.cream.co.backcreamline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cream.co.backcreamline.Model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
