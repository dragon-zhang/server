package com.sa.server.controller.query;

import com.sa.server.pojo.Card;
import com.sa.server.pojo.LeasedCard;
import com.sa.server.pojo.common.JSONResult;
import com.sa.server.service.LeasedCardService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @ApiOperation(value = "根据用户id查询所租用卡", notes = "根据用户id查询所租用卡的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer", paramType = "query")
    })
    public JSONResult queryLeasedCard(@RequestParam String tenantId,
                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "5") Integer pageSize) {
        List<LeasedCardVO> leasedCardList = leasedCardService.queryLeasedCard(tenantId, pageNum, pageSize);
        return JSONResult.ok(leasedCardList);
    }

    @Data
    public static class LeasedCardVO {

        private String id;

        /**
         * 发行卡id
         */
        private Card card;

        /**
         * 0表示次数卡,1表示时间卡
         */
        private Integer type;

        /**
         * 可用次数,时间卡的可用次数为-1
         */
        private Integer availableTimes;

        /**
         * 过期时间,次数卡的过期时间为null
         */
        private Date expirationDate;

        /**
         * 租金
         */
        private BigDecimal rent;

        /**
         * 租户id,来源于user表
         */
        private String tenantId;

        /**
         * 租赁时间
         */
        private Date rentalTime;

        public LeasedCardVO(LeasedCard leasedCard, Card card) {
            this.id = leasedCard.getId();
            this.card = card;
            this.type = leasedCard.getType();
            this.availableTimes = leasedCard.getAvailableTimes();
            this.expirationDate = leasedCard.getExpirationDate();
            this.rent = leasedCard.getRent();
            this.tenantId = leasedCard.getTenantId();
            this.rentalTime = leasedCard.getRentalTime();
        }
    }
}
