package com.sa.server.service;

import com.sa.server.controller.query.LeasedCardQueryController;
import com.sa.server.pojo.LeasedCard;

import java.util.List;

/**
* @author H
* @date 2019年4月23日 
* @description 
*/
public interface LeasedCardService {
	
	/**
	 * @description 增加一条租卡记录
	 * @param leasedCard 包含所必要的字段信息
	 * @return 
	 */
	boolean insertLeasedCard(LeasedCard leasedCard);
	
	/**
	 * @description 根据用户分页查询所租用卡
	 * @return
	 */
    List<LeasedCardQueryController.LeasedCardVO> queryLeasedCard(String tenantId, int pageNum, int pageSize);
}
