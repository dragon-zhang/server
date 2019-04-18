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
public class Card {
    /**
     * 自增主键
     */
    @Id
    private Long aid;

    /**
     * 发行卡id
     */
    private String id;

    /**
     * 发行人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 发行时间
     */
    @Column(name = "issue_time")
    private Date issueTime;

    /**
     * 发行版本
     */
    @Column(name = "issue_version")
    private String issueVersion;

    /**
     * 发行卡等级，如:金,银,铜
     */
    private String grade;

    /**
     * 1逻辑删除，0不删除
     */
    private Boolean dr;
    
}