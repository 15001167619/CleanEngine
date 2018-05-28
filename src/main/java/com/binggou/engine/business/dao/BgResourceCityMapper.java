package com.binggou.engine.business.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.binggou.engine.business.entity.BgResourceCity;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-28 14:50
 */
public interface BgResourceCityMapper extends BaseMapper<BgResourceCity> {


    List<BgResourceCity> selectAllCity();

}
