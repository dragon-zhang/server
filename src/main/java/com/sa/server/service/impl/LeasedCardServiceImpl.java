package com.sa.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.sa.server.controller.query.LeasedCardQueryController;
import com.sa.server.dao.CardMapper;
import com.sa.server.dao.LeasedCardMapper;
import com.sa.server.pojo.LeasedCard;
import com.sa.server.service.LeasedCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author H
 * @date 2019年4月23日
 * @description
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LeasedCardServiceImpl implements LeasedCardService {

    private final CardMapper cardMapper;

    private final LeasedCardMapper leasedCardMapper;

    private final Sid sid;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean insertLeasedCard(LeasedCard leasedCard) {
        leasedCard.setId(sid.nextShort());
        leasedCard.setRentalTime(new Date());
        return leasedCardMapper.insert(leasedCard) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<LeasedCardQueryController.LeasedCardVO> queryLeasedCard(String tenantId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(LeasedCard.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tenantId", tenantId);
        List<LeasedCard> list = leasedCardMapper.selectByExample(example);
        List<LeasedCardQueryController.LeasedCardVO> vos = new ArrayList<>(list.size());
        for (LeasedCard leasedCard : list) {
            vos.add(new LeasedCardQueryController.LeasedCardVO(leasedCard,
                    cardMapper.queryById(leasedCard.getCardId())));
        }
        return vos;
    }

}
