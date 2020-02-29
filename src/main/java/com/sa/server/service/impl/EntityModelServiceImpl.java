package com.sa.server.service.impl;

import com.sa.server.dao.EntityMapper;
import com.sa.server.dao.HaveMapper;
import com.sa.server.dao.ModelMapper;
import com.sa.server.idworker.Sid;
import com.sa.server.pojo.Entity;
import com.sa.server.pojo.Have;
import com.sa.server.pojo.Model;
import com.sa.server.service.EntityModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author H
 * @date 2019年4月29日
 * @description
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EntityModelServiceImpl implements EntityModelService {

    private final EntityMapper entityMapper;

    private final ModelMapper modelMapper;

    private final HaveMapper haveMapper;

    private final Sid sid;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void upperShelf(String storeId, Model model, Entity entity) {
        Example example = new Example(Model.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", model.getName());
        criteria.andEqualTo("brand", model.getBrand());
        criteria.andEqualTo("msrp", model.getMsrp());
        Model alreadyHave = modelMapper.selectOneByExample(example);
        if (alreadyHave == null) {
            model.setId(sid.nextShort());
            modelMapper.insert(model);
            entity.setModuleId(model.getId());
        } else {
            entity.setModuleId(alreadyHave.getId());
        }
        entity.setId(sid.nextShort());
        entity.setSelled(false);
        entityMapper.insert(entity);
        Have have = new Have();
        have.setEntityId(entity.getId());
        have.setStoreId(storeId);
        haveMapper.insert(have);
    }

}
