/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2023/10/13
 */
package com.ledgerserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


//@RestController
//@RequestMapping("/mydb")
@SpringBootTest
class DbController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
//    @GetMapping("/getUsers")
//    public List<Map<String, Object>> getUsers() {
//        System.out.println("哈哈哈");
//        String sql = "select * from user";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        System.out.println(list + "______________________");
//        return list;
//    }
//
//
//    public static void main(String[] args) {
//
//    }

    @Test
    void contextLoads() throws Exception {
        System.out.println("获取的数据库连接为：" + dataSource.getConnection());
    }
}


