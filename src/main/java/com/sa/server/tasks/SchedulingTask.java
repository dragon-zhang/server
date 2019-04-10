package com.sa.server.tasks;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sa.server.config.Config;
import com.sa.server.domain.BaiDuApiService;
import com.sa.server.pojo.common.AccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SuccessZhang
 * @date 2019.1.8
 */
@Component
@RequiredArgsConstructor
public class SchedulingTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定义每过30min执行任务
     */
    @Scheduled(fixedDelay = 30 * 60000, initialDelay = 500)
    public void reportCurrentTime() {
        AccessToken accessToken = new AccessToken();
        String json = BaiDuApiService.getInstance().initAccessTokenWithAkSk(Config.apiKey, Config.secretKey);
        JSONObject jsonObject = JSON.parseObject(json);
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
        BaiDuApiService.getInstance().setAccessToken(accessToken.getAccessToken());
        System.out.println("时间:" + DATE_FORMAT.format(new Date()) + ",获取token成功");
    }
}
