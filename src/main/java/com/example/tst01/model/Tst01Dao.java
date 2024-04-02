package com.example.tst01.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.tst01.Users;

@Component
public class Tst01Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    public List<Map<String,Object>> findByArea(String area) {
        String sql = "SELECT * FROM sales_info WHERE area=?";
        return jdbcTemplate.queryForList(sql, area);
    }

    public List<Map<String,Object>> findSalesByArea() {
        String sql = "SELECT area as name, " + //
                     "sum(sales) as value " + //                     
                     "FROM sales_info group by area";
        return jdbcTemplate.queryForList(sql);
    }
           
    public String InsertUsers(Users users) {        
        String sql = "INSERT INTO users (username, age, height, weight) " + //
                     "VALUES (?,?,?,?)";             
        Object[] obj = {users.getUsername(),users.getAge(),users.getHeight(),users.getWeight()};                                     
        jdbcTemplate.update(sql, obj);     
        return "新增成功";           
    }
}
