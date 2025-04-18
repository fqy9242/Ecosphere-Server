package com.ecosphere.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户交易对象 user_deal
 * 
 * @author qht
 * @date 2025-03-19
 */
public class UserDeal {
    private static final long serialVersionUID = 1L;

    /***/
    private Integer id;

    /** 物品名 */
    @Excel(name = "物品名")
    private String goodName;

    /** 发布的交易描述，介绍 */
    @Excel(name = "发布的交易描述，介绍")
    private String dealDescription;

    /** 交换条件 */
    @Excel(name = "交换条件")
    private String exchangeCondition;

    /** 物品类型,标签 */
    @Excel(name = "物品类型,标签")
    private String goodTag;

    /** 发布人id */
    @Excel(name = "发布人id")
    private Integer creatorId;

    /** 交易状态 1发布中0已完成-1已删除 */
    @Excel(name = "交易状态 1发布中0已完成-1已删除")
    private Long dealStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodName", getGoodName())
            .append("dealDescription", getDealDescription())
            .append("exchangeCondition", getExchangeCondition())
            .append("goodTag", getGoodTag())
            .append("creatorId", getCreatorId())
            .append("dealStatus", getDealStatus())
            .toString();
    }
}
