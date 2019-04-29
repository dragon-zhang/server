package com.sa.server.pojo;

import java.math.BigDecimal;

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

	public Model(String name, String brand, String size, BigDecimal msrp, String color, String material) {
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.msrp = msrp;
		this.color = color;
		this.material = material;
	}

    
    
}