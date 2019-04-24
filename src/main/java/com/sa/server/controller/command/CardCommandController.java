package com.sa.server.controller.command;

import com.sa.server.pojo.Card;
import com.sa.server.service.CardService;
import com.sa.server.util.JSONResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author H
 * @date 2019年4月21日
 * @description
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/card")
public class CardCommandController {

    private final CardService cardService;

    @PostMapping("/create")
    @ApiOperation(value = "商家添加发行卡", notes = "商家添加发行卡的接口")
    public JSONResult createCard(@RequestBody Card cards) {
        String[] grades = cards.getGrade().split("，");
        for (String grade : grades) {
            Card card = new Card();
            BeanUtils.copyProperties(cards, card);
            card.setGrade(grade);
            card.setIssueTime(new Date());
            boolean createCard = cardService.createCard(card);
            if (!createCard) {
                return JSONResult.errorMsg("操作失败！");
            }
        }
        return JSONResult.ok("添加成功");
    }

    @PutMapping("/updateA")
    @ApiOperation(value = "根据自增主键修改发行卡信息", notes = "商家根据自增主键aid修改发行卡信息的接口")
    public JSONResult updateCardByAid(@RequestBody Card card) {
        boolean updateCardAid = cardService.updateCardAid(card);
        return updateCardAid ? JSONResult.ok("修改成功！") : JSONResult.errorMsg("操作失败！");
    }

    @PutMapping("/update")
    @ApiOperation(value = "根据发行卡id修改发行卡信息", notes = "商家根据发行卡id修改发行卡信息的接口")
    public JSONResult updateCardById(@RequestBody Card card) {
        boolean cardById = cardService.updateCardById(card);
        return cardById ? JSONResult.ok("修改成功！") : JSONResult.errorMsg("操作失败！");
    }

    @PutMapping("/deletedr")
    @ApiOperation(value = "修改发行卡dr属性逻辑删除", notes = "商家根据aid对发行卡进行逻辑删除的接口")
    @ApiImplicitParam(name = "id", value = "发行卡id", required = true, dataType = "String", paramType = "query")
    public JSONResult deletedr(String id) {
        boolean deleteCardDr = cardService.deleteCardDr(id);
        return deleteCardDr ? JSONResult.ok("删除成功！") : JSONResult.errorMsg("操作失败！");
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除发行卡", notes = "根据id删除发行卡的接口")
    @ApiImplicitParam(name = "id", value = "发行卡id", required = true, dataType = "String", paramType = "query")
    public JSONResult delete(String id) {
        boolean deleteCard = cardService.deleteCard(id);
        return deleteCard ? JSONResult.ok("删除成功！") : JSONResult.errorMsg("操作失败！");
    }

}
