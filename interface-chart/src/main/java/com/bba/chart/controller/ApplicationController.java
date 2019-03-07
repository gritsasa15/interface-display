package com.bba.chart.controller;

import com.bba.chart.entity.AppInfo;
import com.bba.chart.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping(value = "/getAllApps", method = RequestMethod.GET)
    @ResponseBody
    public List<AppInfo> getAllApps() {
        return appInfoService.getAllApps();
    }

    @RequestMapping(value = "/getAllPlant", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllPlant() {
        return appInfoService.getAllPlant();
    }

    @RequestMapping(value = "/queryByPlant", method = RequestMethod.POST)
    @ResponseBody
    public List<AppInfo> queryByPlant(@RequestParam String plant) {
        return appInfoService.queryByPlant(plant);
    }

    @RequestMapping(value = "/queryByAppId", method = RequestMethod.POST)
    @ResponseBody
    public AppInfo queryByAppId(@RequestParam String appId) {
        return appInfoService.queryByAppId(appId);
    }

    @RequestMapping(value = "/queryByAppName", method = RequestMethod.POST)
    @ResponseBody
    public AppInfo queryByAppName(@RequestParam String appName) {
        return appInfoService.queryByAppName(appName);
    }




}
