package com.sa.server.controller.query;

import com.sa.server.dao.StoreMapper;
import com.sa.server.pojo.Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author success zhang
 * @date 2018.4.24
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/store")
public class StoreQueryController {

    private final StoreMapper storeMapper;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Store> search(@RequestParam String userId) {
        return storeMapper.queryByUserId(userId);
    }
}