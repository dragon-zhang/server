package com.sa.server.service;

import com.sa.server.pojo.Store;

/**
* @author H
* @date 2019年4月21日 
* @description 
*/
public interface StoreService {
	
	/**
	 * @description 创建店铺
	 * @param userId 创始人id
	 * @param store 店铺信息
	 */
	void createStore(String userId,Store store);
	
}
