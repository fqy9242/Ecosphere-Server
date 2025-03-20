package com.ecosphere.service;

import java.util.List;
import com.ecosphere.domain.UserDeal;

/**
 * 用户交易Service接口
 * 
 * @author qht
 * @date 2025-03-19
 */
public interface IUserDealService 
{
    /**
     * 查询用户交易
     * 
     * @param id 用户交易主键
     * @return 用户交易
     */
    public UserDeal selectUserDealById(String id);

    /**
     * 查询用户交易列表
     * 
     * @param userDeal 用户交易
     * @return 用户交易集合
     */
    public List<UserDeal> selectUserDealList(UserDeal userDeal);

    /**
     * 新增用户交易
     * 
     * @param userDeal 用户交易
     * @return 结果
     */
    public int insertUserDeal(UserDeal userDeal);

    /**
     * 修改用户交易
     * 
     * @param userDeal 用户交易
     * @return 结果
     */
    public int updateUserDeal(UserDeal userDeal);

    /**
     * 批量删除用户交易
     * 
     * @param ids 需要删除的用户交易主键集合
     * @return 结果
     */
    public int deleteUserDealByIds(String[] ids);

    /**
     * 删除用户交易信息
     * 
     * @param id 用户交易主键
     * @return 结果
     */
    public int deleteUserDealById(String id);
}
