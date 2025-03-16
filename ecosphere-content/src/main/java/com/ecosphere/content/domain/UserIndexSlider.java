package com.ecosphere.content.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;

/**
 * 首页轮播图对象 user_index_slider
 * 
 * @author qht
 * @date 2025-02-05
 */
public class UserIndexSlider extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 轮播图url */
    @Excel(name = "轮播图url")
    private String photo;

    /** 状态 */
    @Excel(name = "状态")
    private Long photoStatus;

    /** 描述 */
    @Excel(name = "描述")
    private String photoDesc;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setPhotoStatus(Long photoStatus) 
    {
        this.photoStatus = photoStatus;
    }

    public Long getPhotoStatus() 
    {
        return photoStatus;
    }
    public void setPhotoDesc(String photoDesc) 
    {
        this.photoDesc = photoDesc;
    }

    public String getPhotoDesc() 
    {
        return photoDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("photo", getPhoto())
            .append("photoStatus", getPhotoStatus())
            .append("photoDesc", getPhotoDesc())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
