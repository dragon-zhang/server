package com.sa.server.controller.command;

import com.alibaba.fastjson.JSONObject;
import com.sa.server.dao.UserMapper;
import com.sa.server.pojo.User;
import com.sa.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author success zhang
 * @date 2018.12.29
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "rest/v1/user")
public class UserCommandController {

    private final UserMapper userMapper;

    private final UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User save(@RequestBody JSONObject json, HttpServletRequest request) {
        return userService.save(json, request.getAttribute("ip").toString());
    }

    @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User setType(@RequestParam String id, @RequestParam String type) {
        User user = userMapper.queryById(id);
        if (user == null) {
            throw new RuntimeException("user " + id + " not exist!");
        }
        user.setType(type);
        userMapper.setType(id, type);
        return user;
    }

    @PostMapping(value = "/register/face", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String save(@RequestBody JSONObject json) {
        System.out.println("json->" + json.toJSONString());
        return userService.saveWithFace(json);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int update(@RequestBody User user) {
        if (userMapper.queryById(user.getId()) == null) {
            throw new RuntimeException("the user id:" + user.getId() + " is not exist");
        }
        return userMapper.update(user);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int delete(@RequestParam String id) {
        if (userMapper.queryById(id) == null) {
            throw new RuntimeException("the user id:" + id + " is not exist");
        }
        return userMapper.delete(id);
    }
}