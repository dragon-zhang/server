package com.sa.server.controller.query;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.server.dao.CardMapper;
import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;
import com.sa.server.pojo.common.JSONResult;
import com.sa.server.service.CardService;

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

    private final CardMapper cardMapper;

    private final CardService cardService;

    @GetMapping("/query")
    @ApiOperation(value = "根据发行人查询发行卡列表", notes = "根据发行人查询发行卡列表的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "发行人id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer", paramType = "query")
    })
    public JSONResult queryCard(@RequestParam String userId,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "5") Integer pageSize) {
        List<Card> cardList = cardService.queryCardsByUserId(userId, pageNum, pageSize);
        return JSONResult.ok(cardList);
    }

    @GetMapping("/fuzzy")
    @ApiOperation(value = "模糊查询发行卡信息", notes = "模糊查询发行卡信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location", value = "店铺所在地", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sname", value = "店铺名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "scope", value = "经营范围", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "issueVersion", value = "发行版本", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "grade", value = "发行卡等级", required = false, dataType = "String", paramType = "query")
    })
    public JSONResult fuzzyQueryCard(@RequestParam String location,
                                     @RequestParam String sname,
                                     @RequestParam String scope,
                                     @RequestParam String version,
                                     @RequestParam String grade) {

        List<CardDetail> cardList = cardService.fuzzyQueryCard(location, sname, scope, version, grade);
        if (cardList == null || cardList.isEmpty()) {
            return JSONResult.errorMsg("无相关内容。");
        }
        return JSONResult.ok(cardList);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Card> queryAll(@RequestParam String version,
                               @RequestParam String grade) {
        if (StringUtils.isBlank(version)) {
            version = null;
        }
        if (StringUtils.isBlank(grade)) {
            grade = null;
        }
        return cardMapper.queryByVersionAndGrade(version, grade);
    }

}
