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
 * @date 2018-05-28 14:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BgResourceCity  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer provinceId;

    private String cityName;

    private Integer isOrder;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
