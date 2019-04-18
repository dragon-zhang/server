package com.sa.server.pojo;

import java.math.BigDecimal;
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
@Table(name = "leased_card")
public class LeasedCard {
    @Id
    private String id;

    /**
     * 发行卡id
     */
    @Column(name = "card_id")
    private String cardId;

    /**
     * 0表示次数卡,1表示时间卡
     */
    private Integer type;

    /**
     * 可用次数,时间卡的可用次数为-1
     */
    @Column(name = "available_times")
    private Integer availableTimes;

    /**
     * 过期时间,次数卡的过期时间为null
     */
    @Column(name = "expiration_date")
    private Date expirationDate;

    /**
     * 租金
     */
    private BigDecimal rent;

    /**
     * 租户id,来源于user表
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 租赁时间
     */
    @Column(name = "rental_time")
    private Date rentalTime;

}