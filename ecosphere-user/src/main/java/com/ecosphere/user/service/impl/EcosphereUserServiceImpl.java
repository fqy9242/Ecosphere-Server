package com.ecosphere.user.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecosphere.common.constant.MessageConstants;
import com.ecosphere.common.core.domain.model.LoginUser;
import com.ecosphere.common.exception.base.BaseException;
import com.ecosphere.common.utils.DateUtils;
import com.ecosphere.common.utils.SendEmailUtils;
import com.ecosphere.framework.web.service.TokenService;
import com.ecosphere.user.domain.Dto.UserLoginDto;
import com.ecosphere.user.domain.Dto.UserRegisterDto;
import com.ecosphere.user.domain.vo.UserLoginVo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ecosphere.user.mapper.EcosphereUserMapper;
import com.ecosphere.common.domain.entity.EcosphereUser;
import com.ecosphere.user.service.IEcosphereUserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SendEmailUtils emailUtils;

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
                .eq(EcosphereUser::getEmail, userLoginDto.getEmail())
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
        return getUserLoginVo(user);
    }

    @Override
    public UserLoginVo register(UserRegisterDto dto) throws Exception {
        // 判断是否发送了验证码
        if (dto.getCode() == null) {
            throw new BaseException(MessageConstants.CODE_NOT_SEND);
        }
        // 判断验证码是否正确
        String code = redisTemplate.opsForValue().get(dto.getEmail());
        if (code == null || !code.equals(dto.getCode())) {
            throw new BaseException(MessageConstants.CODE_INCORRECT);
        }
        // 验证码正确，判断用户是否存在
        EcosphereUser user = lambdaQuery()
                .eq(EcosphereUser::getEmail, dto.getEmail())
                .one();
        // 用户已存在
        if (user != null) {
            throw new BaseException(MessageConstants.USER_ALREADY_EXIST);
        }
        // 用户不存在，注册用户
        user = new EcosphereUser();
        user.setEmail(dto.getEmail());
        user.setPassword(DigestUtils.md5DigestAsHex(dto.getPassword().getBytes()));
        user.setCreateTime(DateUtils.getNowDate());
        user.setUpdateTime(DateUtils.getNowDate());
        user.setUsername(dto.getUsername());
        // 保存用户
        int result = ecosphereUserMapper.insert(user);
        if (result > 0) {
            // 注册成功，生成token，构建vo
            // 发送邮件
            emailUtils.sendRegisterSuccessMail(dto.getEmail(), dto.getUsername());
            return getUserLoginVo(user);
        }
        return null;
    }

    @NotNull
    private UserLoginVo getUserLoginVo(EcosphereUser user) {
        UserLoginVo vo = new UserLoginVo();
        BeanUtils.copyProperties(user, vo);
        LoginUser loginUser = new LoginUser();
        loginUser.setEcosphereUser(user);
        String token = tokenService.createToken(loginUser);
        vo.setToken(token);
        return vo;
    }
}
