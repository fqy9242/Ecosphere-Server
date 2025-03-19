package com.ecosphere.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;

/**
 * 用户交易对象 user_deal
 * 
 * @author qht
 * @date 2025-03-19
 */
public class UserDeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String id;

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
    private String creatorId;

    /** 交易状态 1发布中0已完成-1已删除 */
    @Excel(name = "交易状态 1发布中0已完成-1已删除")
    private Long dealStatus;

    /** 用户交易物品图片信息 */
    private List<UserDealGoodImg> userDealGoodImgList;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setGoodName(String goodName) 
    {
        this.goodName = goodName;
    }

    public String getGoodName() 
    {
        return goodName;
    }

    public void setDealDescription(String dealDescription) 
    {
        this.dealDescription = dealDescription;
    }

    public String getDealDescription() 
    {
        return dealDescription;
    }

    public void setExchangeCondition(String exchangeCondition) 
    {
        this.exchangeCondition = exchangeCondition;
    }

    public String getExchangeCondition() 
    {
        return exchangeCondition;
    }

    public void setGoodTag(String goodTag) 
    {
        this.goodTag = goodTag;
    }

    public String getGoodTag() 
    {
        return goodTag;
    }

    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }

    public void setDealStatus(Long dealStatus) 
    {
        this.dealStatus = dealStatus;
    }

    public Long getDealStatus() 
    {
        return dealStatus;
    }

    public List<UserDealGoodImg> getUserDealGoodImgList()
    {
        return userDealGoodImgList;
    }

    public void setUserDealGoodImgList(List<UserDealGoodImg> userDealGoodImgList)
    {
        this.userDealGoodImgList = userDealGoodImgList;
    }

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
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userDealGoodImgList", getUserDealGoodImgList())
            .toString();
    }
}
