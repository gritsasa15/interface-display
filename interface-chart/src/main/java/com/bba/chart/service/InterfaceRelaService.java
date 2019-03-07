package com.bba.chart.service;

import com.baomidou.mybatisplus.service.IService;
import com.bba.chart.entity.InterfaceRela;

import java.util.List;

public interface InterfaceRelaService extends IService<InterfaceRela> {

    List<InterfaceRela> getAll();

    List<InterfaceRela> queryByApp(String app);

    List<InterfaceRela> queryBySrcApp(String app);

    List<InterfaceRela> queryByDesApp(String app);

}
