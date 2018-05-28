package com.binggou.engine.business.mongo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-28 15:11
 */
public interface IMongoService {

    List<JSONObject> findAllData(String collectionName);

    void deleteDataByKey(String collectionName,String key);
}
