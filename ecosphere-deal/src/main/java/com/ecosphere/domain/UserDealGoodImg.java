package com.ecosphere.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;

/**
 * 用户交易物品图片对象 user_deal_good_img
 * 
 * @author qht
 * @date 2025-03-19
 */
public class UserDealGoodImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 交易物品id */
    @Excel(name = "交易物品id")
    private Long dealGoodId;

    /** 图片url */
    @Excel(name = "图片url")
    private String imgUrl;

    /** 0未删除 1已删除 */
    private String isDelete;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDealGoodId(Long dealGoodId) 
    {
        this.dealGoodId = dealGoodId;
    }

    public Long getDealGoodId() 
    {
        return dealGoodId;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setIsDelete(String isDelete) 
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dealGoodId", getDealGoodId())
            .append("imgUrl", getImgUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
