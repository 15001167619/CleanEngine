package com.binggou.engine.config;


import com.binggou.engine.common.utils.ToolUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * * beetl拓展配置,绑定一些工具类,方便在模板中直接调用
 * @date 2018-04-25 14:13
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
    }

}
