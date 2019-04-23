package com.sa.server.controller.command;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.Store;
import com.sa.server.service.StoreService;
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
@RequestMapping(value = "rest/v1/store")
public class StoreCommandController {
	
	private final StoreService storeService;
	
	@PutMapping("/create")
	@ApiOperation(value="创始人创建店铺",notes="创始人创建店铺的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "创始人id", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "sname", value = "店铺名", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "店铺尺寸", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "scope", value = "店铺经营范围", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "location", value = "店铺位置", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "base64image", value = "店铺图片的base64编码", required = true, dataType = "String", paramType = "query"),
	})
	public JSONResult createStore(String userId, String sname, String size, String scope, String location, String base64image) {
		
		if(StringUtils.isBlank(userId) || StringUtils.isBlank(sname) || StringUtils.isBlank(size) || StringUtils.isBlank(scope) ||
				StringUtils.isBlank(location) || StringUtils.isBlank(base64image)) {
			return JSONResult.errorMsg("参数出错！");
		}
		try {
			Store store = new Store(Integer.parseInt(size), location, base64image, scope, sname);
			storeService.createStore(userId, store);
		}catch (NumberFormatException e) {
			return JSONResult.errorMsg("参数格式有误！");
		}catch(Exception e) {
			return JSONResult.errorMsg("创建失败！");
		}
		return JSONResult.ok();
	}
		
}
