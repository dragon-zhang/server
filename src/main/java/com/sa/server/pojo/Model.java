package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author SuccessZhang
 * @date 2020/01/03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 模型id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 大小,如:10*10*10，单位cm3
     */
    private String size;

    /**
     * 制造商建议零售价
     */
    private BigDecimal msrp;

    /**
     * 颜色
     */
    private String color;

    /**
     * 材质
     */
    private String material;
}