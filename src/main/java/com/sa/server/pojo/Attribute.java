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
public class Attribute {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 模型id
     */
    @Column(name = "model_id")
    private String modelId;

    /**
     * 附加属性id
     */
    private String id;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 字段名称
     */
    private String name;

}