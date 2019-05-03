package com.sa.server.dao;

import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;
import com.sa.server.util.generator.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SuccessZhang
 */
public interface CardMapper extends MyMapper<Card> {

    /**
     * 根据发行版本和等级查询卡
     *
     * @param version 发行版本
     * @param grade   发行等级
     * @return 符合条件的卡列表
     */
    List<Card> queryByVersionAndGrade(@Param("version") String version,
                                      @Param("grade") String grade);

    /**
     * 模糊查询卡
     *
     * @param location 店铺地点
     * @param sname    店铺名称
     * @param scope    店铺经营范围
     * @param version  发行版本
     * @param grade    发行等级
     * @return 符合条件的卡列表
     */
    List<CardDetail> getDetails(@Param("location") String location,
                                @Param("sname") String sname,
                                @Param("scope") String scope,
                                @Param("version") String version,
                                @Param("grade") String grade);

    /**
     * 根据卡id查询卡
     *
     * @param id 卡id
     * @return 卡
     */
    Card queryById(@Param("id") String id);
}