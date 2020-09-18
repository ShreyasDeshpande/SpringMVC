package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AlienModel;

@Repository
public interface AlienRepository extends JpaRepository<AlienModel, Integer> {

}
