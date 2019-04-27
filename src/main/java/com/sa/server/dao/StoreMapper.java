package com.sa.server.dao;

import com.sa.server.pojo.Store;
import com.sa.server.util.generator.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author H
 * @date 2019/04/18
 * @description
 */
public interface StoreMapper extends MyMapper<Store> {

    /**
     * 根据用户id查询用户所拥有的商店
     *
     * @param userId 用户id
     * @return 用户所拥有的商店
     */
    List<Store> queryByUserId(@Param("userId") String userId);

    /**
     * 根据地点、店名、经营范围查询用户所拥有的商店
     *
     * @param location 店铺地点
     * @param sname    店铺名称
     * @param scope    店铺经营范围
     * @return 符合条件的商店列表
     */
    List<Store> queryByLocationAndSnameAndScope(@Param("location") String location,
                                                @Param("sname") String sname,
                                                @Param("scope") String scope);

}