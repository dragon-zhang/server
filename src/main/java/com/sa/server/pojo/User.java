package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author SuccessZhang
 * @date 2019/01/03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 腾讯openid可唯一标识一个QQ用户
     */
    private String openid;

    /**
     * 新浪微博uid可唯一标识一个微博用户
     */
    private String uid;

    /**
     * 百度人脸用户id
     */
    @Column(name = "face_id")
    private String faceId;

    /**
     * 百度人脸用户组
     */
    @Column(name = "face_group")
    private String faceGroup;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户类型
     */
    private String type;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 会员到期时间
     */
    @Column(name = "membership_expire_time")
    private Date membershipExpireTime;

    /**
     * 最近一次登录IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最近一次登录日期
     */
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 1逻辑删除，0不删除
     */
    private Boolean dr;
}