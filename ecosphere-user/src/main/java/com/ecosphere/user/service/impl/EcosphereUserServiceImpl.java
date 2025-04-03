package com.ecosphere.user.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecosphere.common.constant.MessageConstants;
import com.ecosphere.common.core.domain.model.LoginUser;
import com.ecosphere.common.exception.base.BaseException;
import com.ecosphere.common.utils.DateUtils;
import com.ecosphere.framework.web.service.TokenService;
import com.ecosphere.user.domain.Dto.UserLoginDto;
import com.ecosphere.user.domain.vo.UserLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecosphere.user.mapper.EcosphereUserMapper;
import com.ecosphere.common.domain.entity.EcosphereUser;
import com.ecosphere.user.service.IEcosphereUserService;
import org.springframework.util.DigestUtils;

/**
 * 注册用户Service业务层处理
 * 
 * @author qht
 * @date 2025-03-19
 */
@Service
public class EcosphereUserServiceImpl extends ServiceImpl<EcosphereUserMapper, EcosphereUser> implements IEcosphereUserService
{
    @Autowired
    private EcosphereUserMapper ecosphereUserMapper;
    @Autowired
    private TokenService tokenService;

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

    /**
     * 获取注册用户数量
     *
     * @return 结果
     */
//    @Override
//    public Integer count() {
//        return ecosphereUserMapper.count();
//    }

    /**
     * 用户登录
     *
     * @param userLoginDto dto对俩
     * @return 结果
     */
    @Override
    public UserLoginVo login(UserLoginDto userLoginDto) {
        // 判断用户是否存在
        EcosphereUser user = lambdaQuery()
                .eq(EcosphereUser::getUsername, userLoginDto.getUsername())
                .one();
        // 用户不存在，抛出异常
        if (user == null) {
            throw new BaseException(MessageConstants.USER_NOT_EXIST);
        }
        // 用户存在，判断密码是否正确
        String encrypt = DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes());
        // 密码不正确
        if (user.getPassword() == null  || !user.getPassword().equals(encrypt)) {
            throw new BaseException(MessageConstants.PASSWORD_INCORRECT);
        }
        // 密码正确，生成token，构建vo
        UserLoginVo vo = new UserLoginVo();
        BeanUtils.copyProperties(user, vo);
        LoginUser loginUser = new LoginUser();
        loginUser.setEcosphereUser(user);
        String token = tokenService.createToken(loginUser);
        vo.setToken(token);
        return vo;
    }
}
