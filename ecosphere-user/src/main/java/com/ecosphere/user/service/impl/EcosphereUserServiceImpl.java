package com.ecosphere.user.service.impl;

import java.util.List;
import com.ecosphere.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecosphere.user.mapper.EcosphereUserMapper;
import com.ecosphere.user.domain.EcosphereUser;
import com.ecosphere.user.service.IEcosphereUserService;

/**
 * 注册用户Service业务层处理
 * 
 * @author qht
 * @date 2025-03-19
 */
@Service
public class EcosphereUserServiceImpl implements IEcosphereUserService 
{
    @Autowired
    private EcosphereUserMapper ecosphereUserMapper;

    /**
     * 查询注册用户
     * 
     * @param id 注册用户主键
     * @return 注册用户
     */
    @Override
    public EcosphereUser selectEcosphereUserById(String id)
    {
        return ecosphereUserMapper.selectEcosphereUserById(id);
    }

    /**
     * 查询注册用户列表
     * 
     * @param ecosphereUser 注册用户
     * @return 注册用户
     */
    @Override
    public List<EcosphereUser> selectEcosphereUserList(EcosphereUser ecosphereUser)
    {
        return ecosphereUserMapper.selectEcosphereUserList(ecosphereUser);
    }

    /**
     * 新增注册用户
     * 
     * @param ecosphereUser 注册用户
     * @return 结果
     */
    @Override
    public int insertEcosphereUser(EcosphereUser ecosphereUser)
    {
        ecosphereUser.setCreateTime(DateUtils.getNowDate());
        return ecosphereUserMapper.insertEcosphereUser(ecosphereUser);
    }

    /**
     * 修改注册用户
     * 
     * @param ecosphereUser 注册用户
     * @return 结果
     */
    @Override
    public int updateEcosphereUser(EcosphereUser ecosphereUser)
    {
        ecosphereUser.setUpdateTime(DateUtils.getNowDate());
        return ecosphereUserMapper.updateEcosphereUser(ecosphereUser);
    }

    /**
     * 批量删除注册用户
     * 
     * @param ids 需要删除的注册用户主键
     * @return 结果
     */
    @Override
    public int deleteEcosphereUserByIds(String[] ids)
    {
        return ecosphereUserMapper.deleteEcosphereUserByIds(ids);
    }

    /**
     * 删除注册用户信息
     * 
     * @param id 注册用户主键
     * @return 结果
     */
    @Override
    public int deleteEcosphereUserById(String id)
    {
        return ecosphereUserMapper.deleteEcosphereUserById(id);
    }
}
