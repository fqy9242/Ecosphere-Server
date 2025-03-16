package com.ecosphere.content.mapper;

import java.util.List;
import com.ecosphere.content.domain.UserIndexSlider;

/**
 * 首页轮播图Mapper接口
 * 
 * @author qht
 * @date 2025-02-05
 */
public interface UserIndexSliderMapper 
{
    /**
     * 查询首页轮播图
     * 
     * @param id 首页轮播图主键
     * @return 首页轮播图
     */
    public UserIndexSlider selectUserIndexSliderById(Long id);

    /**
     * 查询首页轮播图列表
     * 
     * @param userIndexSlider 首页轮播图
     * @return 首页轮播图集合
     */
    public List<UserIndexSlider> selectUserIndexSliderList(UserIndexSlider userIndexSlider);

    /**
     * 新增首页轮播图
     * 
     * @param userIndexSlider 首页轮播图
     * @return 结果
     */
    public int insertUserIndexSlider(UserIndexSlider userIndexSlider);

    /**
     * 修改首页轮播图
     * 
     * @param userIndexSlider 首页轮播图
     * @return 结果
     */
    public int updateUserIndexSlider(UserIndexSlider userIndexSlider);

    /**
     * 删除首页轮播图
     * 
     * @param id 首页轮播图主键
     * @return 结果
     */
    public int deleteUserIndexSliderById(Long id);

    /**
     * 批量删除首页轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserIndexSliderByIds(Long[] ids);
}
