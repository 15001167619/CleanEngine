package com.binggou.engine.business.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.binggou.engine.business.entity.BgResourceCategory;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-28 13:43
 */
public interface BgResourceCategoryMapper extends BaseMapper<BgResourceCategory> {

    BgResourceCategory selectByPrimaryKey(Integer id);

    BgResourceCategory selectByCategoryName(String categoryName);

    BgResourceCategory selectFirstByCategoryName(String categoryName);

}
