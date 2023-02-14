package com.momin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momin.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}

