package com.sa.server.controller.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.Card;
import com.sa.server.service.CardService;
import com.sa.server.util.JSONResult;

import io.swagger.annotations.ApiImplicitParam;
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
	@ApiImplicitParam(name = "userId", value = "发行人id", required = true, dataType = "String", paramType = "query")
	public JSONResult queryCard(String userId) {
		List<Card> cardList = cardService.queryCardsByUserId(userId);
		return JSONResult.ok(cardList);
	}
	
}
