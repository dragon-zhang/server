package com.sa.server.dao;

import com.sa.server.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SuccessZhang
 * @date 2018/12/29
 */
public interface UserMapper {

    /**
     * 根据手机号查询用户
     *
     * @param mobile 手机号
     * @return 用户信息
     */
    User queryByMobile(@Param("mobile") String mobile);

    /**
     * 根据邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户信息
     */
    User queryByEmail(@Param("email") String email);

    /**
     * 保存用户信息
     *
     * @param user 待保存的用户信息
     */
    void save(User user);

    /**
     * 修改用户信息
     *
     * @param user 待修改的用户信息
     * @return 成功修改返回1
     */
    int update(User user);

    /**
     * 逻辑删除用户信息
     *
     * @param id 待删除的用户id
     * @return 成功逻辑删除返回1
     */
    int delete(@Param("id") String id);

    /**
     * 按照module中不为空的数据作为条件查询
     *
     * @param module 查询条件
     * @param skip   返回第一行记录的偏移量
     * @param limit  返回记录的最大数目
     * @return 符合条件的用户列表
     */
    List<User> queryByModule(@Param("module") User module,
                             @Param("skip") int skip,
                             @Param("limit") int limit);

    /**
     * 按照module中不为空的数据作为条件计数
     *
     * @param module 查询条件
     * @return 符合条件的用户总数
     */
    long countByModule(User module);

    /**
     * 按照腾讯openid查询
     *
     * @param openid openid
     * @return 用户信息
     */
    User queryByOpenId(@Param("openid") String openid);

    /**
     * 按照新浪uid查询
     *
     * @param uid uid
     * @return 用户信息
     */
    User queryByUid(@Param("uid") String uid);

    /**
     * 按照用户id查询
     *
     * @param id id
     * @return 用户信息
     */
    User queryById(@Param("id") String id);

    /**
     * 设置用户类型
     *
     * @param id   用户id
     * @param type 用户类型
     */
    void setType(@Param("id") String id,
                 @Param("type") String type);

    /**
     * 按照用户aid查询
     *
     * @param aid aid
     * @return 用户信息
     */
    User queryByAid(Long aid);
}