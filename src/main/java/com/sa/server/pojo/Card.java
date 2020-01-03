package com.sa.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author SuccessZhang
 * @date 2020/01/03
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