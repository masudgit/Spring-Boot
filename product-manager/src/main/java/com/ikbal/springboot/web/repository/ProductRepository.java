package com.ikbal.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikbal.springboot.web.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}