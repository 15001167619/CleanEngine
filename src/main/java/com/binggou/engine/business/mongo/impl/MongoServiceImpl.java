package com.binggou.engine.business.mongo.impl;

import com.alibaba.fastjson.JSONObject;
import com.binggou.engine.business.mongo.IMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-28 15:26
 */
@Service
public class MongoServiceImpl implements IMongoService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<JSONObject> findAllData(String collectionName) {
        return mongoTemplate.find(new Query(), JSONObject.class, collectionName);
    }

    @Override
    public void deleteDataByKey(String collectionName, String key) {
        Query query=new Query(Criteria.where("项目编号").is(key));
        mongoTemplate.remove(query,collectionName);
    }
}
