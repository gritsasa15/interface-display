package com.bba.chart.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bba.chart.entity.InterfaceRela;
import com.bba.chart.mapper.InterfaceRelaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterfaceRelaServiceImpl extends ServiceImpl<InterfaceRelaMapper, InterfaceRela> implements InterfaceRelaService {


    @Override
    public List<InterfaceRela> getAll() {
        EntityWrapper<InterfaceRela> ew = new EntityWrapper<>();
        return this.selectList(ew);
    }

    @Override
    public List<InterfaceRela> queryByApp(String app) {
        EntityWrapper<InterfaceRela> ew = new EntityWrapper<>();
        ew.eq("SRC_APP", app).or().eq("DES_APP", app);
        return this.selectList(ew);
    }

    @Override
    public List<InterfaceRela> queryBySrcApp(String app) {
        EntityWrapper<InterfaceRela> ew = new EntityWrapper<>();
        ew.eq("SRC_APP", app);
        return this.selectList(ew);
    }

    @Override
    public List<InterfaceRela> queryByDesApp(String app) {
        EntityWrapper<InterfaceRela> ew = new EntityWrapper<>();
        ew.eq("DES_APP", app);
        return this.selectList(ew);
    }
}
