package com.picpaysimplificado.repository;

import com.picpaysimplificado.domain.transaction.Transction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transction, Long> {
}
