package com.sa.server.controller.query;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sa.server.dao.UserMapper;
import com.sa.server.mybatis.plugin.MyFirstPlugin;
import com.sa.server.pojo.User;
import com.sa.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    private final UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User login(@RequestBody JSONObject json) {
        return userService.login(json);
    }

    @PostMapping(value = "/login/face", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User faceLogin(@RequestBody JSONObject json) {
        return userService.faceLogin(json);
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