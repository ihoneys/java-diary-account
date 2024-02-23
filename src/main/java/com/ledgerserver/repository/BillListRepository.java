package com.ledgerserver.repository;

import com.ledgerserver.entity.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillListRepository extends PagingAndSortingRepository<Bill, Integer> {
    Bill findById(int id);
}
