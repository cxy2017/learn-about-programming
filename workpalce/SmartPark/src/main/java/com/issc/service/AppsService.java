package com.issc.service;

import com.issc.dao.AppsRepository;
import com.issc.entity.Apps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppsService {

    @Autowired
    private AppsRepository appsRepository;

    public String getApp(int id){
        Apps apps= appsRepository.findById(id);
        String app=apps.toString();
        if (app==null){
            return "false";
        }else {

            return app;
        }
    }
}
