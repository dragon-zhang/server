/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.sa.server.domain;

import com.sa.server.pojo.common.RequestParams;
import com.sa.server.util.HttpUtil;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author SuccessZhang
 * @date 2018.12.26
 */
@Service
@Data
public class BaiDuApiService {

    private static final String BASE_URL = "https://aip.baidubce.com";

    private static final String ACCESS_TOKEN_URL = BASE_URL + "/oauth/2.0/token?";

    private static final String REG_URL = BASE_URL + "/rest/2.0/face/v3/faceset/user/add";

    private static final String IDENTIFY_URL = BASE_URL + "/rest/2.0/face/v3/search";

    private String accessToken;

    private String groupId;

    private BaiDuApiService() {
        // 采用deviceId分组
        HttpUtil.getInstance().init();
    }

    private static volatile BaiDuApiService instance;

    public static BaiDuApiService getInstance() {
        if (instance == null) {
            synchronized (BaiDuApiService.class) {
                if (instance == null) {
                    instance = new BaiDuApiService();
                }
            }
        }
        return instance;
    }

    /**
     * 明文aksk获取token
     */
    public String initAccessTokenWithAkSk(String ak, String sk) {
        String sb = "client_id=" + ak +
                "&client_secret=" + sk +
                "&grant_type=client_credentials";
        return HttpUtil.getInstance().getAccessToken(ACCESS_TOKEN_URL, sb);
    }

    /**
     * 注册
     */
    public String reg(String base64Img, String uid, String username) {
        RequestParams params = new RequestParams();
        params.setImgType("BASE64");
        params.setBase64Img(base64Img);
        params.setGroupId(groupId);
        params.setUserId(uid);
        params.setUserInfo(username);
        // 参数可以根据实际业务情况灵活调节
        params.setQualityControl("NONE");
        params.setLivenessControl("NORMAL");
        String url = urlAppendCommonParams(REG_URL);
        return HttpUtil.getInstance().post(url, params);
    }

    /**
     * 查询
     */
    public String identify(String base64Img, String uid) {
        RequestParams params = new RequestParams();
        params.setImgType("BASE64");
        params.setBase64Img(base64Img);
        if (uid != null) {
            params.setUserId(uid);
        }
        params.setGroupIdList(groupId);
        // 可以根据实际业务情况灵活调节
        params.setQualityControl("NORMAL");
        params.setLivenessControl("NORMAL");
        String url = urlAppendCommonParams(IDENTIFY_URL);
        return HttpUtil.getInstance().post(url, params);
    }

    /**
     * URL append access token，sdkversion，aipdevid
     */
    private String urlAppendCommonParams(String url) {
        return url + "?access_token=" + accessToken;
    }

}
