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