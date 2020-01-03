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