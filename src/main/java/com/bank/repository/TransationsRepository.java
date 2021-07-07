package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.model.Transaction;

@Repository
public interface TransationsRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "select t from transactions t where t.account_id=:accountId", nativeQuery = true)
	List<Transaction> findByAccountsId(@Param("accountId") Long accountId);

	@Query(value = "select t from transactions t where t.account_id=:accountId and t.id=:id", nativeQuery = true)
	Transaction getByAccountsIdAndId(@Param("accountId") Long accountId, @Param("id") Long id);

}
