package com.sa.server.service.impl;

import java.util.Date;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.server.dao.BelongMapper;
import com.sa.server.dao.StoreMapper;
import com.sa.server.dao.UserMapper;
import com.sa.server.pojo.Belong;
import com.sa.server.pojo.Store;
import com.sa.server.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* @author H
* @date 2019年4月21日 
* @description 与店铺相关的业务
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService {

	private final StoreMapper storeMapper;
	private final BelongMapper belongMapper;
	private final Sid sid;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void createStore(String userId, Store store) {
		store.setId(sid.nextShort());
		store.setDr(false);
		store.setCreateTime(new Date());
		storeMapper.insert(store);
		Belong belong = new Belong();
		belong.setUserId(userId);
		belong.setStoreId(store.getId());
		belongMapper.insert(belong);
	}
	
	
}
