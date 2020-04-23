package com.issc.controller;

import com.issc.service.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/apps")
public class AppsController {
    @Autowired
    private AppsService appsService;

    @RequestMapping("/indexApps")
    @ResponseBody
    public String indexApps(int id){
        return appsService.getApp(id);
    }
}
