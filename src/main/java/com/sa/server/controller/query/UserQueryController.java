package com.sa.server.controller.query;

import com.alibaba.fastjson.JSONObject;
import com.sa.server.pojo.User;
import com.sa.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author success zhang
 * @date 2018.12.29
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/user")
public class UserQueryController {

    private final UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User login(@RequestBody JSONObject json) {
        return userService.login(json);
    }

    @PostMapping(value = "/login/face", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User faceLogin(@RequestBody JSONObject json) {
        return userService.faceLogin(json);
    }

}