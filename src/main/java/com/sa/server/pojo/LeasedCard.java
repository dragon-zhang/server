package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author SuccessZhang
 * @date 2020/01/03
 */
@Table(name = "leased_card")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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