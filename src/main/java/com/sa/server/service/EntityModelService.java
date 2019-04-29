package com.sa.server.service;

import com.sa.server.pojo.Entity;
import com.sa.server.pojo.Model;

/**
* @author H
* @date 2019年4月29日 
* @description 
*/
public interface EntityModelService {

	/**
	 * @description 上架商品
	 */
	void upperShelf(String storeId, Model model, Entity entity);
	
}
