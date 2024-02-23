/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/21
 */
package com.ledgerserver.controller;


import cn.hutool.core.date.DateUtil;
import com.ledgerserver.common.Constants;
import com.ledgerserver.common.Response;
import com.ledgerserver.common.Result;
import com.ledgerserver.common.ResultCode;
import com.ledgerserver.common.response.BillList;
import com.ledgerserver.entity.Bill;
import com.ledgerserver.repository.BillListRepository;
import com.ledgerserver.repository.UserRepository;
import com.ledgerserver.service.BillService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import utils.UserUtil;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/bill")
public class BillListController {

    @Autowired
    private BillService billService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BillListRepository billListRepository;

    @PostMapping("add")
    public Result addBill(@RequestBody Bill bill, HttpServletRequest request) {

        // TODO: 判断Bill类型不能为空
        if(bill.getTypeName().isEmpty()) {
            return Response.failure(ResultCode.PARAMS_IS_BLANK);
        }

        int userId = UserUtil.getUserIdFormToken(request, userRepository);

        bill.setUserId(userId);
        billService.createBill(bill);
        return Response.success();
    }


    @GetMapping("list")
    public Result<BillList> getBill(@Param("page") String page, @Param("date") String date
        , @Param("page_size") String page_size, @Param("type_id") String type_id
    ) {
        String format = "YYYY-MM";
        int pageNum = page.isEmpty() ? 1 : Integer.parseInt(page);

        PageRequest pageRequest = PageRequest.of( pageNum - 1, Integer.parseInt(page_size));
        Page<Bill> pageBill = billListRepository.findAll(pageRequest);
        long total = pageBill.getTotalElements();
        List<Bill> billList = pageBill.getContent();
        List<Bill> monthBills = billList.stream().filter(d -> DateUtil.format(DateUtil.parse(d.getDate()), format).equals(date)).toList();
        BillList billListObject = new BillList();

        billListObject.setTotalPage(total);

        BigDecimal totalExpense = monthBills.stream().map(d -> d.getPayType() == Constants.PAY_TYPE_IN ? new BigDecimal(d.getAmount()) : BigDecimal.ZERO).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalCome = monthBills.stream().map(d -> d.getPayType() == Constants.PAY_TYPE_OUT  ? new BigDecimal(d.getAmount()) : BigDecimal.ZERO).reduce(BigDecimal.ZERO, BigDecimal::add);

        billListObject.setTotalExpense(totalExpense);
        billListObject.setTotalIncome(totalCome);

        // 组装 list , item: date、bills
        List<Map<String, Object>> billsData = new ArrayList<>();
        monthBills.stream().forEach(d -> {
            Map<String, Object> billListItem = new HashMap<>();
            String curDate = DateUtil.formatDate(DateUtil.parse(d.getDate()));
            billListItem.put("date", curDate);
            billListItem.put("bills", monthBills.stream().filter(item -> DateUtil.formatDate(DateUtil.parse(item.getDate())).equals(curDate)).toList());

            billsData.add(billListItem);

            billListObject.setList(billsData);
        });


        return Response.success(billListObject);
    }

    @GetMapping("detail")
    public Result<Bill> getBillDetail(@Param("id") int id) {
        Bill billDetail = billListRepository.findById(id);
        return Response.success(billDetail);
    }
}
