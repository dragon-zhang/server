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
 * @date 2020/01/03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 店铺id
     */
    private String id;

    /**
     * 店铺大小
     * /m2
     */
    private Integer size;

    /**
     * 店铺地点
     */
    private String location;

    /**
     * 店面印象
     */
    private String base64image;

    /**
     * 经营范围
     */
    private String scope;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 1逻辑删除，0不删除
     */
    private Boolean dr;

    private String sname;

    /**
     * 创始人id
     */
    @Column(name = "user_id")
    private String userId;
}