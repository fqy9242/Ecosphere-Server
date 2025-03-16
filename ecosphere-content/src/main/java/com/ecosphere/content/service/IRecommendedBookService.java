package com.ecosphere.content.service;

import java.util.List;
import com.ecosphere.content.domain.RecommendedBook;

/**
 * 推荐书籍Service接口
 * 
 * @author qht
 * @date 2025-02-05
 */
public interface IRecommendedBookService 
{
    /**
     * 查询推荐书籍
     * 
     * @param id 推荐书籍主键
     * @return 推荐书籍
     */
    public RecommendedBook selectRecommendedBookById(String id);

    /**
     * 查询推荐书籍列表
     * 
     * @param recommendedBook 推荐书籍
     * @return 推荐书籍集合
     */
    public List<RecommendedBook> selectRecommendedBookList(RecommendedBook recommendedBook);

    /**
     * 新增推荐书籍
     * 
     * @param recommendedBook 推荐书籍
     * @return 结果
     */
    public int insertRecommendedBook(RecommendedBook recommendedBook);

    /**
     * 修改推荐书籍
     * 
     * @param recommendedBook 推荐书籍
     * @return 结果
     */
    public int updateRecommendedBook(RecommendedBook recommendedBook);

    /**
     * 批量删除推荐书籍
     * 
     * @param ids 需要删除的推荐书籍主键集合
     * @return 结果
     */
    public int deleteRecommendedBookByIds(String[] ids);

    /**
     * 删除推荐书籍信息
     * 
     * @param id 推荐书籍主键
     * @return 结果
     */
    public int deleteRecommendedBookById(String id);
}
