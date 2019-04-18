package com.sa.server.pojo;

import java.util.Date;

import javax.persistence.*;

import com.sa.server.pojo.User.UserBuilder;

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