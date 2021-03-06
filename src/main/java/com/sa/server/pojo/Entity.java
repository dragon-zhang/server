package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author H
 * @date 2019/04/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entity {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 模型id
     */
    @Column(name = "module_id")
    private String moduleId;

    /**
     * 实体id
     */
    private String id;

    /**
     * 生产日期
     */
    @Column(name = "produce_date")
    private Date produceDate;

    /**
     * 保修到期时间
     */
    @Column(name = "warranty_expiration_date")
    private Date warrantyExpirationDate;

    /**
     * 是否保修
     */
    private Boolean guarantee;

    /**
     * 是否被售出,1被售出,0未被售出
     */
    private Boolean selled;

    /**
     * 被售出时的价格,未被售出时该字段为空
     */
    @Column(name = "selled_price")
    private BigDecimal selledPrice;

    public Entity(Date produceDate, Date warrantyExpirationDate, Boolean guarantee) {
        this.produceDate = produceDate;
        this.warrantyExpirationDate = warrantyExpirationDate;
        this.guarantee = guarantee;
    }


}