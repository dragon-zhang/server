package com.sa.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author SuccessZhang
 * @date 2018.12.28
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@Configuration
@MapperScan(value = "com.sa.server.dao")
//开启定时同步任务
@EnableScheduling
//开启异步任务
@EnableAsync
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}

