package com.sa.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.sa.server.dao.UserMapper;
import com.sa.server.domain.BaiDuApiService;
import com.sa.server.pojo.User;
import com.sa.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author SuccessZhang
 * @date 2018.12.29
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User save(JSONObject json, String realIP) {
        User user = new User();
        String registerType = json.getString("register_type");
        if ("qq".equals(registerType)) {
            /*qq json结构
             {
             "msg": "",
             "is_lost": 0,
             "gender": "男",
             "city": "抚州",
             "year": "1998",
             "figureurl_2": "http://qzapp.qlogo.cn/qzapp/1108058960/5598F91CDB94E18A90251CADB389B42F/100",
             "figureurl_1": "http://qzapp.qlogo.cn/qzapp/1108058960/5598F91CDB94E18A90251CADB389B42F/50",
             "is_yellow_year_vip": "0",
             "province": "江西",
             "constellation": "",
             "figureurl": "http://qzapp.qlogo.cn/qzapp/1108058960/5598F91CDB94E18A90251CADB389B42F/30",
             "nickname": "炼龙",
             "yellow_vip_level": "0",
             "vip": "0",
             "expires_in": 7776000,
             "ret": 0,
             "is_yellow_vip": "0",
             "pay_token": "7654BF614756CF64F27FE925A96B4840",
             "level": "0",
             "openid": "5598F91CDB94E18A90251CADB389B42F",
             "login_cost": 102,
             "access_token": "B09F80B54220BE00CABC621F1776E04A",
             "pfkey": "63842a00064a0287a8d852e85cae19dd",
             "pf": "desktop_m_qq-10000144-android-2002-",
             "query_authority_cost": 1099,
             "figureurl_qq_1": "http://thirdqq.qlogo.cn/qqapp/1108058960/5598F91CDB94E18A90251CADB389B42F/40",
             //下面的为QQ头像
             "figureurl_qq_2": "http://thirdqq.qlogo.cn/qqapp/1108058960/5598F91CDB94E18A90251CADB389B42F/100",
             "expires_time": 1553673125824,
             "authority_cost": 0
             }
             */
            String openid = json.getString("openid");
            User qqUser = userMapper.queryByOpenId(openid);
            if (qqUser != null) {
                return qqUser;
            }
            user.setOpenid(openid);
            user.setAvatar(json.getString("figureurl_qq_2"));
            user.setName(json.getString("nickname"));
            user.setGender(json.getString("gender"));
        } else if ("sina".equals(registerType)) {
            /*sinaUserInfo，sina唯一编号id
             {
             "allow_all_act_msg": false,
             "favourites_count": 0,
             "urank": 3,
             "verified_trade": "",
             "weihao": "",
             "verified_source_url": "",
             "province": "100",
             "screen_name": "炼龙45391",
             "id": 6721409826,
             "geo_enabled": true,
             "like_me": false,
             "like": false,
             "verified_type": -1,
             "pagefriends_count": 0,
             "domain": "",
             "following": false,
             "name": "炼龙45391",
             "cover_image_phone": "http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg",
             "idstr": "6721409826",
             "follow_me": false,
             "friends_count": 6,
             "credit_score": 80,
             "gender": "m",
             "city": "1000",
             "profile_url": "u/6721409826",
             "description": "",
             "created_at": "Mon Sep 24 12:35:00 +0800 2018",
             "remark": "",
             "ptype": 0,
             "verified_reason_url": "",
             "block_word": 0,
             "avatar_hd": "http://tvax4.sinaimg.cn/crop.0.0.40.40.1024/007kSlJUly8fvkiv7not8j3014014dfl.jpg",
             "mbtype": 0,
             "bi_followers_count": 0,
             "user_ability": 0,
             "verified_reason": "",
             "story_read_state": -1,
             "video_status_count": 0,
             "mbrank": 0,
             "lang": "zh-cn",
             "class": 1,
             "star": 0,
             "allow_all_comment": true,
             "online_status": 0,
             "verified": false,
             "profile_image_url": "http://tvax4.sinaimg.cn/crop.0.0.40.40.50/007kSlJUly8fvkiv7not8j3014014dfl.jpg",
             "block_app": 0,
             "url": "",
             "avatar_large": "http://tvax4.sinaimg.cn/crop.0.0.40.40.180/007kSlJUly8fvkiv7not8j3014014dfl.jpg",
             "statuses_count": 0,
             "vclub_member": 0,
             "followers_count": 1,
             "location": "其他",
             "insecurity": {
             "sexual_content": false
             },
             "verified_source": ""
             }*/
            String uid = json.getString("idstr");
            User sinaUser = userMapper.queryByUid(uid);
            if (sinaUser != null) {
                return sinaUser;
            }
            user.setUid(uid);
            user.setAvatar(json.getString("avatar_hd"));
            user.setName(json.getString("name"));
            String gender = json.getString("gender");
            if ("m".equals(gender)) {
                user.setGender("男");
            } else if ("w".equals(gender)) {
                user.setGender("女");
            }
        } else if ("common".equals(registerType)) {
            String mobile = json.getString("mobile");
            User commonUser = userMapper.queryByMobile(mobile);
            if (commonUser != null) {
                return commonUser;
            }
            user.setType(json.getString("type"));
            user.setMobile(mobile);
            user.setEmail(json.getString("email"));
            user.setPassword(json.getString("password"));
        }
        user.setLastLoginIp(realIP);
        userMapper.save(user);
        return user;
    }

    @Override
    public User saveWithFace(JSONObject json, String realIP) {
        String base64Img = json.getString("base64Img");
        String identityResult = BaiDuApiService.getInstance()
                .identify(base64Img, null);
        JSONObject jsonObject = JSON.parseObject(identityResult);
        if (jsonObject.getIntValue("error_code") == 0) {
            log.error("the user already exists!");
            throw new RuntimeException("the user already exists!");
        }
        if (jsonObject.getString("result") == null) {
            throw new RuntimeException(jsonObject.getString("error_msg"));
        }
        User user = new User();
        user.setName(json.getString("username"));
        user.setLastLoginIp(realIP);
        user.setFaceGroup(json.getString("group"));
        userMapper.save(user);
        user = userMapper.queryByAid(user.getAid());
        BaiDuApiService.getInstance()
                .reg(base64Img,
                        user.getFaceId(),
                        user.getName());
        return user;
    }

    @Override
    public User login(JSONObject json) {
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

    @Override
    public User faceLogin(JSONObject json) {
        String result = BaiDuApiService.getInstance()
                .identify(json.getString("base64Img"),
                        json.getString("faceId"));
        double maxScore = 0;
        String faceId = "";
        if (StringUtils.isBlank(result)) {
            return null;
        }
        try {
            JSONObject resObj = JSON.parseObject(result).getJSONObject("result");
            if (resObj != null) {
                JSONArray resArray = resObj.getJSONArray("user_list");
                for (Object o : resArray) {
                    JSONObject s = (JSONObject) o;
                    if (s != null) {
                        double score = s.getDouble("score");
                        if (score > maxScore) {
                            maxScore = score;
                            faceId = s.getString("user_id");
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (maxScore > 90) {
            return userMapper.queryByFaceId(faceId);
        }
        return null;
    }
}
