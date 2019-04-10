package com.sa.server;

import com.sa.server.config.Config;
import com.sa.server.domain.BaiDuApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author SuccessZhang
 * @date 2019.1.7
 */
@Component
@RequiredArgsConstructor
public class BaiDuApiInit implements CommandLineRunner {

    @Override
    public void run(String... args) {
        BaiDuApiService.getInstance().setGroupId(Config.groupID);
        System.out.println("百度API初始化成功");
    }
}