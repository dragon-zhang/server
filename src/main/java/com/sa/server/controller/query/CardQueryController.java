package com.sa.server.controller.query;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;
import com.sa.server.service.CardService;
import com.sa.server.util.JSONResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* @author H
* @date 2019年4月21日 
* @description 
*/

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/card")
public class CardQueryController {

	private final CardService cardService;
	
	
	@GetMapping("/query")
	@ApiOperation(value="根据发行人查询发行卡列表",notes="根据发行人查询发行卡列表的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "发行人id", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer", paramType = "query"),
		@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer", paramType = "query")
	})
	public JSONResult queryCard(String userId ,Integer pageNum, Integer pageSize) {
		if( pageNum == null ) pageNum = 1;
		if( pageSize == null ) pageSize = 5;
		List<Card> cardList = cardService.queryCardsByUserId(userId, pageNum, pageSize);
		return JSONResult.ok(cardList);
	}
	
	@GetMapping("/fuzzy")
	@ApiOperation(value="模糊查询发行卡信息",notes="模糊查询发行卡信息的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户Id", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "用户名", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "location", value = "店铺所在地", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "sname", value = "店铺名", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "scope", value = "经营范围", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "issueVersion", value = "发行版本", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "grade", value = "发行卡等级", required = false, dataType = "String", paramType = "query")
	})
	public JSONResult fuzzyQueryCard(String userId,String name, String location, String sname, String scope, String issueVersion, String grade) {     
		
		if(StringUtils.isBlank(userId) && StringUtils.isBlank(name) && StringUtils.isBlank(location) && StringUtils.isBlank(sname) && 
				StringUtils.isBlank(scope) && StringUtils.isBlank(issueVersion) && StringUtils.isBlank(grade)) {
			return JSONResult.errorMsg("参数出错!");
		}
		
		List<CardDetail> cardList = cardService.fuzzyQueryCard(userId, name, location, sname, scope, issueVersion, grade);
		if(cardList == null || cardList.isEmpty()) {
			return JSONResult.errorMsg("无相关内容。");
		}
		return JSONResult.ok(cardList);
	}
}
