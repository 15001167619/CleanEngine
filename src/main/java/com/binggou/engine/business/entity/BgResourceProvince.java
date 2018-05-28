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
 * @date 2018-05-28 14:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BgResourceProvince  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer countryID;

    private String provinceName;

    private Integer isOrder;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
