package com.sa.server.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

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