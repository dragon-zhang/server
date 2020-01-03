package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author SuccessZhang
 * @date 2020/01/03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Have {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 实例id
     */
    @Column(name = "entity_id")
    private String entityId;
}