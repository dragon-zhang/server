package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
/**
* @author H
* @date 2019/04/18 
* @description 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_detail")
public class CardDetail {
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
     * 用户名
     */
    private String name;

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
     * 店铺名
     */
    private String sname;

    /**
     * 店铺地点
     */
    private String location;

    /**
     * 经营范围
     */
    private String scope;

}