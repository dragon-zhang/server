package com.sa.server.service;

import java.util.List;

import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;

/**
* @author H
* @date 2019年4月21日 
* @description 
*/
public interface CardService {

	/**
	 * @description 商家新增发行卡
	 * @param card
	 * @return 表示创建是否成功
	 */
	boolean createCard(Card card);
	
	/**
	 * @description 根据发行卡自增主键aid修改发行卡信息
	 * @param card 包含主键字段 和 待修改字段即可
	 * @return 表示更新是否成功
	 */
	boolean updateCardAid(Card card);
	
	/**
	 * @description 根据发行卡id修改发行卡信息
	 * @param card 包含发行卡id字段 和 待修改字段即可
	 * @return 表示更新是否成功
	 */
	boolean updateCardById(Card card);
	
	/**
	 * @description 根据发行人id查询所发行卡列表
	 * @param userId
	 * @return 查询结果
	 */
	List<Card> queryCardsByUserId(String userId);
	
	/**
	 * @description 根据发行卡id进行逻辑删除
	 * @return
	 */
	boolean deleteCardDr(String id);
	
	/**
	 * @description 根据发行卡id进行删除
	 * @param aid
	 * @return
	 */
	boolean deleteCard(String id);
	
	List<CardDetail> fuzzyQueryCard(String userId ,String name, String location,String sname,String scope,String issueVersion,String grade);
	
}
