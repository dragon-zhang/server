package com.sa.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.sa.server.dao.CardMapper;
import com.sa.server.idworker.Sid;
import com.sa.server.pojo.Card;
import com.sa.server.pojo.CardDetail;
import com.sa.server.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

/**
 * @author H
 * @date 2019年4月21日
 * @description 与发行卡相关的业务
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardMapper cardMapper;

    private final Sid sid;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean createCard(Card card) {
        card.setId(sid.nextShort());
        card.setDr(false);
        return cardMapper.insert(card) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCardAid(Card card) {
        return cardMapper.updateByPrimaryKeySelective(card) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCardById(Card card) {
        Example example = new Example(Card.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", card.getId());
        return cardMapper.updateByExampleSelective(card, example) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Card> queryCardsByUserId(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Card.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("dr", false);
        return cardMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCardDr(String id) {
        Card card = new Card();
        card.setDr(true);
        Example example = new Example(Card.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return cardMapper.updateByExampleSelective(card, example) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCard(String id) {
        Example example = new Example(Card.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return cardMapper.deleteByExample(example) >= 1 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = RuntimeException.class)
    public List<CardDetail> fuzzyQueryCard(String location,
                                           String sname,
                                           String scope,
                                           String version,
                                           String grade) {
        return cardMapper.getDetails(location, sname, scope, version, grade);
    }


}
