package com.sa.server.controller.command;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.pojo.Entity;
import com.sa.server.pojo.Model;
import com.sa.server.pojo.common.JSONResult;
import com.sa.server.service.EntityModelService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author H
 * @date 2019年4月29日
 * @description
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/entity")
public class EntityModelCommandController {

	private final EntityModelService entityModelService;
	
	@PostMapping("/upperShelf")
	@ApiOperation(value = "商家上架商品", notes = "商家上架商品的接口")
	public JSONResult upperShelf(String storeId, String name, String brand, String size, String msrp, String color,
			String material, Date produceDate, Date warrantyExpirationDate, boolean guarantee ,int number) {

		BigDecimal msrpBd = new BigDecimal(msrp);
		Model model = new Model(name, brand, size, msrpBd, color, material);
		Entity entity = new Entity(produceDate, warrantyExpirationDate, guarantee);
		while(number > 0) {
			entityModelService.upperShelf(storeId, model, entity);
			number--;
		}
		return JSONResult.ok();
	}
}
