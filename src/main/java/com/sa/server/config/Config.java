/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.sa.server.config;

/**
 * @author SuccessZhang
 * @date 2018.12.26
 */
public class Config {

    public static final String IP_AND_PORT = "192.168.43.155:8088";

    //百度人脸识别配置
    /**
     * license为调用sdk的人脸检测功能使用，人脸识别 = 人脸检测（sdk功能）+人脸比对（服务端api）
     */
    public static String apiKey = "AFRocLBoqfsrEGzKAVVGLjI4";
    public static String secretKey = "gkjRLdWk7Fy7RZQrzSLuwQCjIhgsi27G";
    public static String licenseID = "LetMeFold-face-android";
    public static String licenseFileName = "idl-license.face-android";
    /**
     * 每个开发者账号只能创建一个人脸库，groupID用于标识人脸库
     */
    public static String groupID = "User";
    /**
     * 打开扫描界面请求码
     */
    public static final int REQ_QR_CODE = 11002;
    /**
     * 打开摄像头
     */
    public static final int REQ_PERM_CAMERA = 11003;
    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";

    //微博配置
    /**
     * 当前应用的APP_KEY，第三方应用应该使用在新浪开放平台申请的APP_KEY，只有通过微博官方认证的APP_KEY才能生效
     * 微博demo默认：2045436852
     * 随处购：2565969426
     */
    static final String WB_APP_KEY = "2565969426";

    /**
     * 当前应用的回调页，没有定义将无法使用 SDK 认证登录
     * 微博demo默认：http://www.sina.com
     * 随处购：https://api.weibo.com/oauth2/default.html
     */
    static final String WB_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";

    /**
     * Scope 是 OAuth2.0 授权机制中 authorize 接口的一个参数，支持传入多个 Scope 权限，用逗号分隔。
     */
    static final String WB_SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
}