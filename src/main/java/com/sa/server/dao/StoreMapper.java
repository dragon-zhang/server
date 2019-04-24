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

}