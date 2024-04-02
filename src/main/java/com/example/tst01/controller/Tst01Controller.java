package com.example.tst01.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.tst01.service.Tst01Service;
import com.example.tst01.Users;



@RestController
public class Tst01Controller {

    @Autowired
    private Tst01Service tst01Service;
    
    @GetMapping("/area/{area}")
    public List<Map<String,Object>> getMethodName(@PathVariable String area) {
        return tst01Service.getOneAreaSales(area);
    }  
    
    @GetMapping("/areasales")
    public List<Map<String,Object>> getAreaAales() {
        return tst01Service.getAreaSales();
    }   
        
    @GetMapping("/chart")
    public ModelAndView getPieSales() {   
        List<Object> ds = tst01Service.getAreaSalesDoughnut();                   
        ModelAndView model = new ModelAndView();
        model.setViewName("pie_areasales");
        model.addObject("v01", ds.get(0));
        model.addObject("v02", ds.get(1));
        return model;        
    }   

    @PostMapping("/insertuser")
    public String create(@RequestBody Users users){         
        return tst01Service.getInsertUsers(users);
    }
           
    @GetMapping("/admin")
    public ModelAndView getAdminList() {        
        ModelAndView mv = new ModelAndView();         
        mv.setViewName("admin_list");               
        return mv;        
    }  
    
    @GetMapping("/admin/list03")
    public ModelAndView getAdminList_3_3() {        
        ModelAndView mv = new ModelAndView();         
        mv.setViewName("insert_db");                      
        return mv;        
    }    
}
