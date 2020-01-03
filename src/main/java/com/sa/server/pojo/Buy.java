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
public class Buy {
    @Id
    private Long aid;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 实体id
     */
    @Column(name = "entity_id")
    private String entityId;

    /**
     * 使用卡的id,不能用卡或者没有用卡,此字段为空
     */
    @Column(name = "use_leased_card_id")
    private String useLeasedCardId;

    /**
     * 购买日期
     */
    private Date date;
}