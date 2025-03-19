package com.ecosphere.service.impl;

import java.util.List;
import com.ecosphere.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ecosphere.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ecosphere.domain.UserDealGoodImg;
import com.ecosphere.mapper.UserDealMapper;
import com.ecosphere.domain.UserDeal;
import com.ecosphere.service.IUserDealService;

/**
 * 用户交易Service业务层处理
 * 
 * @author qht
 * @date 2025-03-19
 */
@Service
public class UserDealServiceImpl implements IUserDealService 
{
    @Autowired
    private UserDealMapper userDealMapper;

    /**
     * 查询用户交易
     * 
     * @param id 用户交易主键
     * @return 用户交易
     */
    @Override
    public UserDeal selectUserDealById(String id)
    {
        return userDealMapper.selectUserDealById(id);
    }

    /**
     * 查询用户交易列表
     * 
     * @param userDeal 用户交易
     * @return 用户交易
     */
    @Override
    public List<UserDeal> selectUserDealList(UserDeal userDeal)
    {
        return userDealMapper.selectUserDealList(userDeal);
    }

    /**
     * 新增用户交易
     * 
     * @param userDeal 用户交易
     * @return 结果
     */
    @Transactional
    @Override
    public int insertUserDeal(UserDeal userDeal)
    {
        userDeal.setCreateTime(DateUtils.getNowDate());
        int rows = userDealMapper.insertUserDeal(userDeal);
        insertUserDealGoodImg(userDeal);
        return rows;
    }

    /**
     * 修改用户交易
     * 
     * @param userDeal 用户交易
     * @return 结果
     */
    @Transactional
    @Override
    public int updateUserDeal(UserDeal userDeal)
    {
        userDeal.setUpdateTime(DateUtils.getNowDate());
        userDealMapper.deleteUserDealGoodImgByDealGoodId(userDeal.getId());
        insertUserDealGoodImg(userDeal);
        return userDealMapper.updateUserDeal(userDeal);
    }

    /**
     * 批量删除用户交易
     * 
     * @param ids 需要删除的用户交易主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUserDealByIds(String[] ids)
    {
        userDealMapper.deleteUserDealGoodImgByDealGoodIds(ids);
        return userDealMapper.deleteUserDealByIds(ids);
    }

    /**
     * 删除用户交易信息
     * 
     * @param id 用户交易主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUserDealById(String id)
    {
        userDealMapper.deleteUserDealGoodImgByDealGoodId(id);
        return userDealMapper.deleteUserDealById(id);
    }

    /**
     * 新增用户交易物品图片信息
     * 
     * @param userDeal 用户交易对象
     */
    public void insertUserDealGoodImg(UserDeal userDeal)
    {
        List<UserDealGoodImg> userDealGoodImgList = userDeal.getUserDealGoodImgList();
        String id = userDeal.getId();
        if (StringUtils.isNotNull(userDealGoodImgList))
        {
            List<UserDealGoodImg> list = new ArrayList<UserDealGoodImg>();
            for (UserDealGoodImg userDealGoodImg : userDealGoodImgList)
            {
                userDealGoodImg.setDealGoodId(Long.valueOf(id));
                list.add(userDealGoodImg);
            }
            if (list.size() > 0)
            {
                userDealMapper.batchUserDealGoodImg(list);
            }
        }
    }
}
