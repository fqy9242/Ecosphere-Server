package com.ecosphere.content.service.impl;

import java.util.List;
import com.ecosphere.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecosphere.content.mapper.UserIndexSliderMapper;
import com.ecosphere.content.domain.UserIndexSlider;
import com.ecosphere.content.service.IUserIndexSliderService;

/**
 * 首页轮播图Service业务层处理
 * 
 * @author qht
 * @date 2025-02-05
 */
@Service
public class UserIndexSliderServiceImpl implements IUserIndexSliderService 
{
    @Autowired
    private UserIndexSliderMapper userIndexSliderMapper;

    /**
     * 查询首页轮播图
     * 
     * @param id 首页轮播图主键
     * @return 首页轮播图
     */
    @Override
    public UserIndexSlider selectUserIndexSliderById(Long id)
    {
        return userIndexSliderMapper.selectUserIndexSliderById(id);
    }

    /**
     * 查询首页轮播图列表
     * 
     * @param userIndexSlider 首页轮播图
     * @return 首页轮播图
     */
    @Override
    public List<UserIndexSlider> selectUserIndexSliderList(UserIndexSlider userIndexSlider)
    {
        return userIndexSliderMapper.selectUserIndexSliderList(userIndexSlider);
    }

    /**
     * 新增首页轮播图
     * 
     * @param userIndexSlider 首页轮播图
     * @return 结果
     */
    @Override
    public int insertUserIndexSlider(UserIndexSlider userIndexSlider)
    {
        userIndexSlider.setCreateTime(DateUtils.getNowDate());
        return userIndexSliderMapper.insertUserIndexSlider(userIndexSlider);
    }

    /**
     * 修改首页轮播图
     * 
     * @param userIndexSlider 首页轮播图
     * @return 结果
     */
    @Override
    public int updateUserIndexSlider(UserIndexSlider userIndexSlider)
    {
        userIndexSlider.setUpdateTime(DateUtils.getNowDate());
        return userIndexSliderMapper.updateUserIndexSlider(userIndexSlider);
    }

    /**
     * 批量删除首页轮播图
     * 
     * @param ids 需要删除的首页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteUserIndexSliderByIds(Long[] ids)
    {
        return userIndexSliderMapper.deleteUserIndexSliderByIds(ids);
    }

    /**
     * 删除首页轮播图信息
     * 
     * @param id 首页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteUserIndexSliderById(Long id)
    {
        return userIndexSliderMapper.deleteUserIndexSliderById(id);
    }
}
