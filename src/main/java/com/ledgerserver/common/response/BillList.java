/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/22
 */
package com.ledgerserver.common.response;

import com.ledgerserver.entity.Bill;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class BillList {
    private BigDecimal totalExpense;
    private BigDecimal totalIncome;
    private long totalPage;

    private List<Map<String, Object>> list;

    public BillList() {
        this.list = new ArrayList<>();
    }
}
