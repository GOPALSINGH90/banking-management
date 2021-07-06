package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Transation;

@Repository
public interface TransationsRepository extends JpaRepository<Transation, Long>{

}
