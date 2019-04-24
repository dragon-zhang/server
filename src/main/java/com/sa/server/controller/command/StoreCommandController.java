package com.sa.server.controller.command;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sa.server.pojo.Store;
import com.sa.server.service.StoreService;
import com.sa.server.util.JSONResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create")
    @ApiOperation(value = "创始人创建店铺", notes = "创始人创建店铺的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "创始人id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sname", value = "店铺名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "店铺尺寸", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "scope", value = "店铺经营范围", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "location", value = "店铺位置", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "base64image", value = "店铺图片的base64编码", dataType = "String", paramType = "query"),
    })
    public JSONResult createStore(@RequestBody JSONObject json) {
        Store store = JSON.toJavaObject(json, Store.class);
        String userId = json.getString("userId");
        if (StringUtils.isBlank(userId) ||
                StringUtils.isBlank(store.getSname()) ||
                StringUtils.isBlank(String.valueOf(store.getSize())) ||
                StringUtils.isBlank(store.getScope()) ||
                StringUtils.isBlank(store.getLocation())) {
            return JSONResult.errorMsg("参数出错！");
        }
        try {
            storeService.createStore(userId, store);
        } catch (NumberFormatException e) {
            return JSONResult.errorMsg("参数格式有误！");
        } catch (Exception e) {
            return JSONResult.errorMsg("创建失败！");
        }
        return JSONResult.ok();
    }

}
