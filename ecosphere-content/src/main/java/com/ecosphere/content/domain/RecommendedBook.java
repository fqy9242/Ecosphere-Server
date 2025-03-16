package com.ecosphere.content.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;

/**
 * 推荐书籍对象 tb_recommended_book
 * 
 * @author qht
 * @date 2025-02-05
 */
public class RecommendedBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 书名 */
    @Excel(name = "书名")
    private String bookName;

    /** 书的描述,介绍 */
    @Excel(name = "书的描述,介绍")
    private String bookDescription;

    /** 封面 */
    @Excel(name = "封面")
    private String bookCover;

    /** 书籍作者 */
    @Excel(name = "书籍作者")
    private String bookAuthor;

    /** 作者国籍 */
    @Excel(name = "作者国籍")
    private String authorNationality;

    /** 书籍类型 */
    private String bookType;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setBookDescription(String bookDescription) 
    {
        this.bookDescription = bookDescription;
    }

    public String getBookDescription() 
    {
        return bookDescription;
    }
    public void setBookCover(String bookCover) 
    {
        this.bookCover = bookCover;
    }

    public String getBookCover() 
    {
        return bookCover;
    }
    public void setBookAuthor(String bookAuthor) 
    {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() 
    {
        return bookAuthor;
    }
    public void setAuthorNationality(String authorNationality) 
    {
        this.authorNationality = authorNationality;
    }

    public String getAuthorNationality() 
    {
        return authorNationality;
    }
    public void setBookType(String bookType) 
    {
        this.bookType = bookType;
    }

    public String getBookType() 
    {
        return bookType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookName", getBookName())
            .append("bookDescription", getBookDescription())
            .append("bookCover", getBookCover())
            .append("bookAuthor", getBookAuthor())
            .append("authorNationality", getAuthorNationality())
            .append("bookType", getBookType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
