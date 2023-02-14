package com.momin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momin.entity.Charges;
@Repository
public interface ChargesRepo extends JpaRepository<Charges,String> {

}
