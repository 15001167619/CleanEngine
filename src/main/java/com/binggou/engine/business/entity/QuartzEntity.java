package com.binggou.engine.business.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 10:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuartzEntity   extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String jobName = "cleanEngineJob";
    private String jobGroup = "jobGroup";
    private String description = "抓取项目清洗数据";
    private String jobClassName = "com.binggou.engine.job.CleanEngineJob";//执行类
    private String cronExpression = "0/15 * * * * ?";
    private String triggerName;
    private String triggerState;//任务状态

    public QuartzEntity() {
        super();
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
