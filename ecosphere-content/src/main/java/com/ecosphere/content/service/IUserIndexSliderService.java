package com.ecosphere.content.service;

import java.util.List;
import com.ecosphere.content.domain.UserIndexSlider;

/**
 * 首页轮播图Service接口
 * 
 * @author qht
 * @date 2025-02-05
 */
public interface IUserIndexSliderService 
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
     * 批量删除首页轮播图
     * 
     * @param ids 需要删除的首页轮播图主键集合
     * @return 结果
     */
    public int deleteUserIndexSliderByIds(Long[] ids);

    /**
     * 删除首页轮播图信息
     * 
     * @param id 首页轮播图主键
     * @return 结果
     */
    public int deleteUserIndexSliderById(Long id);
}
