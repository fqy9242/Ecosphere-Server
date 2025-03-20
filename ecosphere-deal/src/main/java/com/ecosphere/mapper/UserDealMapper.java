package com.ecosphere.mapper;

import java.util.List;
import com.ecosphere.domain.UserDeal;
import com.ecosphere.domain.UserDealGoodImg;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户交易Mapper接口
 * 
 * @author qht
 * @date 2025-03-19
 */
@Mapper
public interface UserDealMapper 
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
     * 删除用户交易
     * 
     * @param id 用户交易主键
     * @return 结果
     */
    public int deleteUserDealById(String id);

    /**
     * 批量删除用户交易
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserDealByIds(String[] ids);

    /**
     * 批量删除用户交易物品图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserDealGoodImgByDealGoodIds(String[] ids);
    
    /**
     * 批量新增用户交易物品图片
     * 
     * @param userDealGoodImgList 用户交易物品图片列表
     * @return 结果
     */
    public int batchUserDealGoodImg(List<UserDealGoodImg> userDealGoodImgList);
    

    /**
     * 通过用户交易主键删除用户交易物品图片信息
     * 
     * @param id 用户交易ID
     * @return 结果
     */
    public int deleteUserDealGoodImgByDealGoodId(String id);
}
