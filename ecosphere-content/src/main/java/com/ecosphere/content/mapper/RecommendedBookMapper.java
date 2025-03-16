package com.ecosphere.content.mapper;

import java.util.List;
import com.ecosphere.content.domain.RecommendedBook;

/**
 * 推荐书籍Mapper接口
 * 
 * @author qht
 * @date 2025-02-05
 */
public interface RecommendedBookMapper 
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
     * 删除推荐书籍
     * 
     * @param id 推荐书籍主键
     * @return 结果
     */
    public int deleteRecommendedBookById(String id);

    /**
     * 批量删除推荐书籍
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecommendedBookByIds(String[] ids);
}
