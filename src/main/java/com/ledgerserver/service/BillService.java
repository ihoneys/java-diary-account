/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/21
 */
package com.ledgerserver.service;

import com.ledgerserver.entity.Bill;
import com.ledgerserver.repository.UpdateBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    private UpdateBillRepository updateBillRepository;
    public void createBill(Bill bill) {
        updateBillRepository.save(bill);
    }
}
