package com.tpe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BeanController {
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/bean")
    @ResponseBody
public Map<String,String> getBeans(){
        String[] beanNames=applicationContext.getBeanDefinitionNames();
    Map<String,String> map=new HashMap<>();
        for (String beanName:beanNames
             ) {
map.put(beanName,applicationContext.getBean(beanName).toString());

        }
        return map;

    }




}
