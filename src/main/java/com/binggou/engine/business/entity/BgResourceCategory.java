package com.binggou.engine.business.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-28 13:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BgResourceCategory  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String categoryName;

    private String enCategoryName;

    private Integer fatherCatId;

    private String fatherCatName;

    private Integer isOrder;

    private Integer isUse;

    private String remark;

    private LocalDateTime addTime = LocalDateTime.now();

    private String addUser;

    private Date updateTime;

    private String updateUser;

    private Integer templateId;

    private String originalPicUrl;

    private String bigPicUrl;

    private String centerPicUrl;

    private String smallPicUrl;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
