package com.bba.chart.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bba.chart.entity.AppInfo;
import com.bba.chart.mapper.AppInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfo> getAllApps() {
        return this.selectList(new EntityWrapper<AppInfo>());
    }

    @Override
    public List<String> getAllPlant() {
        return appInfoMapper.getAllPlant();
    }

    @Override
    public List<AppInfo> queryByPlant(String plant) {
        EntityWrapper<AppInfo> ew = new EntityWrapper<>();
        ew.eq("PLANT", plant);
        return this.selectList(ew);
    }

    @Override
    public AppInfo queryByAppId(String appId) {
        EntityWrapper<AppInfo> ew = new EntityWrapper<>();
        ew.eq("COMPASS_ID", appId);
        return this.selectOne(ew);
    }

    @Override
    public AppInfo queryByAppName(String appName) {
        EntityWrapper<AppInfo> ew = new EntityWrapper<>();
        ew.eq("APP_NAME", appName);
        return this.selectOne(ew);
    }
}
