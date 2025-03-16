package com.ecosphere.content.service.impl;

import java.util.List;
import com.ecosphere.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecosphere.content.mapper.RecommendedBookMapper;
import com.ecosphere.content.domain.RecommendedBook;
import com.ecosphere.content.service.IRecommendedBookService;

/**
 * 推荐书籍Service业务层处理
 * 
 * @author qht
 * @date 2025-02-05
 */
@Service
public class RecommendedBookServiceImpl implements IRecommendedBookService 
{
    @Autowired
    private RecommendedBookMapper recommendedBookMapper;

    /**
     * 查询推荐书籍
     * 
     * @param id 推荐书籍主键
     * @return 推荐书籍
     */
    @Override
    public RecommendedBook selectRecommendedBookById(String id)
    {
        return recommendedBookMapper.selectRecommendedBookById(id);
    }

    /**
     * 查询推荐书籍列表
     * 
     * @param recommendedBook 推荐书籍
     * @return 推荐书籍
     */
    @Override
    public List<RecommendedBook> selectRecommendedBookList(RecommendedBook recommendedBook)
    {
        return recommendedBookMapper.selectRecommendedBookList(recommendedBook);
    }

    /**
     * 新增推荐书籍
     * 
     * @param recommendedBook 推荐书籍
     * @return 结果
     */
    @Override
    public int insertRecommendedBook(RecommendedBook recommendedBook)
    {
        recommendedBook.setCreateTime(DateUtils.getNowDate());
        return recommendedBookMapper.insertRecommendedBook(recommendedBook);
    }

    /**
     * 修改推荐书籍
     * 
     * @param recommendedBook 推荐书籍
     * @return 结果
     */
    @Override
    public int updateRecommendedBook(RecommendedBook recommendedBook)
    {
        recommendedBook.setUpdateTime(DateUtils.getNowDate());
        return recommendedBookMapper.updateRecommendedBook(recommendedBook);
    }

    /**
     * 批量删除推荐书籍
     * 
     * @param ids 需要删除的推荐书籍主键
     * @return 结果
     */
    @Override
    public int deleteRecommendedBookByIds(String[] ids)
    {
        return recommendedBookMapper.deleteRecommendedBookByIds(ids);
    }

    /**
     * 删除推荐书籍信息
     * 
     * @param id 推荐书籍主键
     * @return 结果
     */
    @Override
    public int deleteRecommendedBookById(String id)
    {
        return recommendedBookMapper.deleteRecommendedBookById(id);
    }
}
