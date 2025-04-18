package com.ecosphere.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.ecosphere.common.utils.DateUtils;
import com.ecosphere.domain.UpdateUserDealDto;
import com.ecosphere.domain.dto.InsertUserDealDto;
import com.ecosphere.domain.vo.UserDealVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

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
    public UserDeal selectUserDealById(String id) {
        return userDealMapper.selectUserDealById(id);
    }

    /**
     * 查询用户交易列表
     * 
     * @param userDeal 用户交易
     * @return 用户交易
     */
    @Override
    public List<UserDealVo> selectUserDealList(UserDeal userDeal) {
         // 查询交易列表
        List<UserDeal> userDeals = userDealMapper.selectUserDealList(userDeal);
        // 创建一个VO对象列表并拷贝属性
        List<UserDealVo> userDealVoList = new ArrayList<>();
        for (UserDeal userDealItem : userDeals) {
            UserDealVo vo = new UserDealVo();
            BeanUtils.copyProperties(userDealItem, vo);
            // 获取商品图片列表
            List<UserDealGoodImg> images = userDealMapper.selectImagesByGoodId(userDealItem.getId());
            vo.setUserDealGoodImgList(images);
            userDealVoList.add(vo);
        }
        return userDealVoList;
    }



    /**
     * 获取交易商品图片
     */
    public List<UserDealGoodImg> getDealImagesById(Integer id) {
        return userDealMapper.selectImagesByGoodId(id);
    }


    /**
     * 新增用户交易
     */
    @Transactional
    @Override
    public void insertUserDeal(InsertUserDealDto dto) {
        // 创建一个entity对象，并将dto对象的属性拷贝过去
        UserDeal userDeal = new UserDeal();
        BeanUtils.copyProperties(dto, userDeal);
        userDeal.setCreateTime(LocalDateTime.now());
        userDeal.setUpdateTime(LocalDateTime.now());
        int id = userDealMapper.insertUserDeal(userDeal);
        // 如果传过来的图片列表不为空，则批量插入到商品图片表

    }

    /**
     * 修改用户交易
     *
     * @param userDeal 用户交易
     * @return 结果
     */

    /**
     * 修改用户交易
     */
    @Transactional
    @Override
    public int updateUserDeal(UpdateUserDealDto dto) {
        userDealMapper.deleteUserDealGoodImgByDealGoodId(String.valueOf(dto.getId()));
        insertUserDealGoodImg(dto.getImageList(), dto.getId());
        return userDealMapper.updateUserDeal(dto);
    }

    /**
     * 批量删除用户交易
     * 
     * @param ids 需要删除的用户交易主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUserDealByIds(String[] ids) {
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
    public int deleteUserDealById(String id) {
        userDealMapper.deleteUserDealGoodImgByDealGoodId(id);
        return userDealMapper.deleteUserDealById(id);
    }

    /**
     * 新增用户交易物品图片信息
     */
    public void insertUserDealGoodImg(List<String> urlList, Integer goodId) {
        if (urlList != null) {
            List<UserDealGoodImg> goodImages = new ArrayList<>();
            urlList.forEach(img -> {
                UserDealGoodImg.builder()
                        .dealGoodId(goodId);
            });
            userDealMapper.batchUserDealGoodImg(goodImages);
        }
    }

}
