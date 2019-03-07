package com.bba.chart.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bba.chart.entity.AppInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfo> {

    List<String> getAllPlant();
}
