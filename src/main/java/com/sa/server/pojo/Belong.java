package com.sa.server.pojo;

import java.util.Date;

import javax.persistence.*;

import com.sa.server.pojo.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author H
* @date 2019/04/18 
* @description 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Belong {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 创始人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private String storeId;

}