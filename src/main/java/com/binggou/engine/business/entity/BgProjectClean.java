package com.binggou.engine.business.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 14:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BgProjectClean extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String projectNumber;
    private String yunProjectNumber;
    private String projectName;
    private LocalDate beginDate = LocalDate.now();
    private LocalDate endDate;
    private Integer noticePeriod;
    private Integer validPeriod;
    private String companyName;
    private String country;
    private String province;
    private String city;
    private String area;
    private String sourceArea;
    private String projectPrice;
    private String firstCategory;
    private String secondCategory;
    private String sourceCategory;
    private Integer dataFrom;
    private String internalReview;
    private String resolutionType;
    private String transactionWay;
    private Double payMoney;
    private String payWay;
    private String payDate;
    private LocalDateTime createDate = LocalDateTime.now();
    private String enterpriseInfo;
    private String stockStructure;
    private String auditReport;
    private String financeReport;
    private String imporInforDisclosure;
    private String transferInfo;
    private String transactionTerm;
    private String motorVehicle;
    private String immovables;
    private String mechanicalEquipment;
    private String rightCategory;
    private String assetType;
    private String transferorName;
    private String file;
    private Integer isChoosed = 0;
    private String remark;
    private String transitEquipment;
    private String stocks;
    private String house;
    private String land;
    private Integer dealStatus = 0;
    private Integer disclosure;
    private String transferOfPropertyRights;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
