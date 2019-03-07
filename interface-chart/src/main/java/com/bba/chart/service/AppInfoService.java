package com.bba.chart.service;

import com.baomidou.mybatisplus.service.IService;
import com.bba.chart.entity.AppInfo;

import java.util.List;

public interface AppInfoService extends IService<AppInfo> {

    List<AppInfo> getAllApps();

    List<String> getAllPlant();

    List<AppInfo> queryByPlant(String plant);

    AppInfo queryByAppId(String appId);

    AppInfo queryByAppName(String appName);

}
