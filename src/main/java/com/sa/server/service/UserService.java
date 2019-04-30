package com.sa.server.service;

import com.alibaba.fastjson.JSONObject;
import com.sa.server.pojo.User;

/**
 * @author SuccessZhang
 * @date 2019/1/3
 */
public interface UserService {

    User save(JSONObject json, String realIP);

    String saveWithFace(JSONObject json, String realIP);

    User login(JSONObject json);

    User faceLogin(JSONObject json);
}
