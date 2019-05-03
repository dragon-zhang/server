package com.sa.server.controller.command;

import com.sa.server.pojo.Entity;
import com.sa.server.pojo.Model;
import com.sa.server.pojo.common.JSONResult;
import com.sa.server.service.EntityModelService;
import com.sa.server.util.TimeUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{storeId}/upperShelf")
    @ApiOperation(value = "商家上架商品", notes = "商家上架商品的接口")
    public JSONResult upperShelf(@PathVariable("storeId") String storeId,
                                 @RequestBody List<Model> models) {
        //随机生成最近三个月的生产日期
        Entity entity;
        for (Model model : models) {
            entity = new Entity(TimeUtil.randomDateTime(-90, 1), null, false);
            entityModelService.upperShelf(storeId, model, entity);
        }
        return JSONResult.ok();
    }
}
