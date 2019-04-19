package com.sa.server.controller.query;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sa.server.dao.UserMapper;
import com.sa.server.domain.BaiDuApiService;
import com.sa.server.mybatis.plugin.MyFirstPlugin;
import com.sa.server.pojo.User;
import com.sa.server.util.JSONResult;

import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author success zhang
 * @date 2018.12.29
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/user")
public class UserQueryController {

    private final UserMapper userMapper;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User login(@RequestBody JSONObject json) {
        User user = userMapper.queryByEmail(json.getString("account"));
        if (user == null) {
            user = userMapper.queryByMobile(json.getString("account"));
        }
        if (user != null && user.getPassword().equals(json.getString("password"))) {
            return user;
        } else {
            return null;
        }
    }
      
    @PostMapping(value = "/login/face", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String faceLogin(@RequestBody JSONObject json) {
        System.out.println("json->" + json.toJSONString());
        return BaiDuApiService.getInstance().identify(json.getString("base64Img"),
                json.getString("uid"));
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<User> search(@RequestParam(defaultValue = "0") int skip,
                             @RequestParam(defaultValue = "20") int limit) {
        User module;
        for (int i = 0; i < 100000; i++) {
            module = userMapper.queryById("04a2536f-0f4a-11e9-8f01-309c23fd150a");
        }
        System.out.println("cost time total : " + MyFirstPlugin.totalTime);
        return null;
    }
}