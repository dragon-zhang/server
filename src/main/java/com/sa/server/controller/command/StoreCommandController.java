package com.sa.server.controller.command;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.Store;
import com.sa.server.service.StoreService;
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
@RequestMapping(value = "rest/v1/store")
public class StoreCommandController {
	
	private final StoreService storeService;
	
	@PutMapping("/create")
	@ApiOperation(value="创始人创建店铺",notes="创始人创建店铺的接口")
	@ApiImplicitParam(name = "userId", value = "创始人id", required = true, dataType = "String", paramType = "query")
	public JSONResult createStore(String userId , @RequestBody Store store) {
		if(StringUtils.isBlank(userId) || store == null) {
			return JSONResult.errorMsg("参数出错！");
		}
		storeService.createStore(userId, store);
		return JSONResult.ok();
	}
	
}
