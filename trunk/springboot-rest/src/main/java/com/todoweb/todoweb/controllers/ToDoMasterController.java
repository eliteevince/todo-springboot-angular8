/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.controllers;

import com.todoweb.todoweb.bean.ToDoBean;
import com.todoweb.todoweb.proxy.ToDoProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PDP_Shiva
 */
@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoMasterController {

    @Autowired
    private ToDoBean doBean;

    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    public Map saveUpdate(@RequestBody ToDoProxy doProxy) {
        try {
            final String saveOrUpdate = doBean.saveOrUpdate(doProxy);
            return new HashMap() {
                {
                    put("msg", saveOrUpdate);
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap() {
                {
                    put("msg", "Exception Occur");
                }
            };
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map deleteToDos(@RequestBody List<Long> ids) {
        try {
            final String saveOrUpdate = doBean.deleteToDo(ids);
            return new HashMap() {
                {
                    put("msg", saveOrUpdate);
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap() {
                {
                    put("msg", "Exception Occur");
                }
            };
        }
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public List<ToDoProxy> getList() {
        try {
            return doBean.getToDoList();
        } catch (Exception e) {
            return null;
        }
    }
}
