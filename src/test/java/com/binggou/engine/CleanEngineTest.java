package com.binggou.engine;

import com.alibaba.fastjson.JSONObject;
import com.binggou.engine.business.dao.BgProjectCleanMapper;
import com.binggou.engine.business.dao.BgResourceCategoryMapper;
import com.binggou.engine.business.dao.BgResourceCityMapper;
import com.binggou.engine.business.dao.BgResourceProvinceMapper;
import com.binggou.engine.business.entity.BgProjectClean;
import com.binggou.engine.business.entity.BgResourceCategory;
import com.binggou.engine.business.entity.BgResourceCity;
import com.binggou.engine.business.entity.BgResourceProvince;
import com.binggou.engine.business.mongo.IMongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 14:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanEngineTest {

    @Autowired
    private BgProjectCleanMapper bgProjectCleanMapper;
    @Autowired
    private BgResourceCategoryMapper categoryMapper;
    @Autowired
    private BgResourceCityMapper cityMapper;
    @Autowired
    private BgResourceProvinceMapper provinceMapper;
    @Autowired
    private IMongoService mongoService;

    @Test
    public void insertTest() throws Exception {
        bgProjectCleanMapper.insertProject(new BgProjectClean());
    }

    @Test
    public void selectTest() throws Exception {
        BgResourceCategory bgResourceCategory;
        bgResourceCategory = categoryMapper.selectByPrimaryKey(11);
        System.out.println(bgResourceCategory);
        bgResourceCategory = categoryMapper.selectByCategoryName("石油天然气开采业");
        System.out.println(bgResourceCategory);
        bgResourceCategory = categoryMapper.selectFirstByCategoryName("建筑业");
        System.out.println(bgResourceCategory);
        List<BgResourceCity> bgResourceCities = cityMapper.selectAllCity();
        System.out.println(bgResourceCities);
        List<BgResourceProvince> bgResourceProvinces = provinceMapper.selectAllProvince();
        System.out.println(bgResourceProvinces);
        BgResourceProvince bgResourceProvince = provinceMapper.selectByPrimaryKey(220000);
        System.out.println(bgResourceProvince);
    }

    @Test
    public void mongoDbTest() throws Exception {
        List<JSONObject> allData = mongoService.findAllData("crawler");
        System.out.println(allData);
        mongoService.deleteDataByKey("crawler","Q318SH1014810");
    }
}
