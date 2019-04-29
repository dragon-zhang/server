package com.sa.server.service.impl;

import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.server.dao.CardMapper;
import com.sa.server.dao.EntityMapper;
import com.sa.server.dao.HaveMapper;
import com.sa.server.dao.ModelMapper;
import com.sa.server.pojo.Entity;
import com.sa.server.pojo.Have;
import com.sa.server.pojo.Model;
import com.sa.server.service.EntityModelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void upperShelf(String storeId, Model model, Entity entity) {
		model.setId(sid.nextShort());
		modelMapper.insert(model);
		entity.setModuleId(model.getId());
		entity.setId(sid.nextShort());
		entity.setSelled(false);
		entityMapper.insert(entity);
		Have have = new Have();
		have.setEntityId(entity.getId());
		have.setStoreId(storeId);
		haveMapper.insert(have);
	}
	
}
