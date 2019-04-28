package com.sa.server.controller.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.LeasedCard;
import com.sa.server.pojo.common.JSONResult;
import com.sa.server.service.LeasedCardService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* @author H
* @date 2019年4月23日 
* @description 
*/
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/leasedcard")
public class LeasedCardQueryController {

	private final LeasedCardService leasedCardService;
	
	@GetMapping("/query")
	@ApiOperation(value="根据用户id查询所租用卡",notes="根据用户id查询所租用卡的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer", paramType = "query"),
		@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer", paramType = "query")
	})
	public JSONResult queryLeasedCard(String tenantId , Integer pageNum, Integer pageSize) {
		if( pageNum == null) pageNum = 1;
		if( pageSize == null) pageSize = 5;
		List<LeasedCard> leasedCardList = leasedCardService.queryLeasedCard(tenantId, pageNum, pageSize);
		return JSONResult.ok(leasedCardList);
	}
}
