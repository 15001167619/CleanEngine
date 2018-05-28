package com.binggou.engine.business.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.binggou.engine.business.entity.BgProjectClean;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 14:35
 */
public interface BgProjectCleanMapper extends BaseMapper<BgProjectClean> {

    int insertProject(BgProjectClean bgProjectClean);

}
