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
public class Value {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 附加属性id
     */
    @Column(name = "attribute_id")
    private String attributeId;

    /**
     * 附加属性值
     */
    private String value;

}