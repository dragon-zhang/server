package com.sa.server.controller.command;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.LeasedCard;
import com.sa.server.service.LeasedCardService;
import com.sa.server.util.JSONResult;

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
public class LeasedCardCommandController {
	
	private final LeasedCardService leasedCardService;
	
	@PostMapping("/rent")
	@ApiOperation(value="用户租用卡",notes="用户租用卡的接口,提供所必须的字段数据即可")
	public JSONResult rentCard(@RequestBody LeasedCard leasedCard) {
		return leasedCardService.insertLeasedCard(leasedCard) ? JSONResult.ok("ok") : JSONResult.errorMsg("租用失败！");
	}
}
