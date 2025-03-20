package com.ecosphere.user.mapper;

import java.util.List;
import com.ecosphere.user.domain.EcosphereUser;

/**
 * 注册用户Mapper接口
 * 
 * @author qht
 * @date 2025-03-19
 */
public interface EcosphereUserMapper 
{
    /**
     * 查询注册用户
     * 
     * @param id 注册用户主键
     * @return 注册用户
     */
    public EcosphereUser selectEcosphereUserById(String id);

    /**
     * 查询注册用户列表
     * 
     * @param ecosphereUser 注册用户
     * @return 注册用户集合
     */
    public List<EcosphereUser> selectEcosphereUserList(EcosphereUser ecosphereUser);

    /**
     * 新增注册用户
     * 
     * @param ecosphereUser 注册用户
     * @return 结果
     */
    public int insertEcosphereUser(EcosphereUser ecosphereUser);

    /**
     * 修改注册用户
     * 
     * @param ecosphereUser 注册用户
     * @return 结果
     */
    public int updateEcosphereUser(EcosphereUser ecosphereUser);

    /**
     * 删除注册用户
     * 
     * @param id 注册用户主键
     * @return 结果
     */
    public int deleteEcosphereUserById(String id);

    /**
     * 批量删除注册用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEcosphereUserByIds(String[] ids);
}
