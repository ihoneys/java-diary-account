package com.ledgerserver.repository;

import com.ledgerserver.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateBillRepository extends JpaRepository<Bill, Integer> {
}
