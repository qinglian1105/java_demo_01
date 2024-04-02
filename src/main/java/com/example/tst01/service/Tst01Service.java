package com.example.tst01.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tst01.model.Tst01Dao;
import com.example.tst01.Users;

@Component
public class Tst01Service {
    @Autowired
    private Tst01Dao tst01Dao;

    public List<Map<String, Object>> getOneAreaSales(String area) {
        List<Map<String, Object>> ds = tst01Dao.findByArea(area);
        if (ds.size() > 0) {
            return ds;
        } else {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("Message:", "No data and please retry...");
            ds.add(map1);
            return ds;
        }
    }

    public List<Map<String, Object>> getAreaSales() {
        return tst01Dao.findSalesByArea();
    }

    public List<Object> getAreaSalesDoughnut() {
        List<Map<String, Object>> ds = tst01Dao.findSalesByArea();                        
        List<Object> nameList=new ArrayList<>();
        List<Object> valueList=new ArrayList<>();                
        for (int i=0, n=ds.size(); i<n ; i++) {            	
            nameList.add(ds.get(i).get("name"));
            valueList.add(ds.get(i).get("value"));
        }
        List<Object> list = new ArrayList<>();
        list.add(nameList);
        list.add(valueList);
        return list;
    }

    public String getInsertUsers(Users users) {
        return tst01Dao.InsertUsers(users);
    }

}
