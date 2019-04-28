package com.sa.server.service;

import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;

import java.util.List;

/**
 * @author H
 * @date 2019年4月21日
 * @description
 */
public interface CardService {

    /**
     * @param card
     * @return 表示创建是否成功
     * @description 商家新增发行卡
     */
    boolean createCard(Card card);

    /**
     * @param card 包含主键字段 和 待修改字段即可
     * @return 表示更新是否成功
     * @description 根据发行卡自增主键aid修改发行卡信息
     */
    boolean updateCardAid(Card card);

    /**
     * @param card 包含发行卡id字段 和 待修改字段即可
     * @return 表示更新是否成功
     * @description 根据发行卡id修改发行卡信息
     */
    boolean updateCardById(Card card);

    /**
     * @param userId
     * @return 查询结果
     * @description 根据发行人id分页查询所发行卡列表
     */
    List<Card> queryCardsByUserId(String userId, int pageNum, int pageSize);

    /**
     * @return
     * @description 根据发行卡id进行逻辑删除
     */
    boolean deleteCardDr(String id);

    /**
     * @param id
     * @return
     * @description 根据发行卡id进行删除
     */
    boolean deleteCard(String id);

    /**
     * @param location
     * @param sname
     * @param scope
     * @param version
     * @param grade
     * @return
     * @description 模糊查询
     */
    List<CardDetail> fuzzyQueryCard(String location, String sname, String scope, String version, String grade);

}
