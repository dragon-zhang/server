package com.sa.server.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author SuccessZhang
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)})
public class MyFirstPlugin implements Interceptor {

    public static long totalTime = 0;

    /**
     * intercept:拦截
     * 拦截目标对象的目标方法的执行:
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行目标方法
        long start = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        // 返回执行后的返回值
        long end = System.currentTimeMillis();
        totalTime = totalTime + (end - start);
        return proceed;
    }

    /**
     * plugin:
     * 包装目标对象:
     * 包装, 为目标对象创建一个代理对象
     */
    @Override
    public Object plugin(Object target) {
        // 我们可以借助Plugin的wrap方法来使用挡圈Interceptor包装我们目标对象
        // 返回为当前target创建的动态代理
        return Plugin.wrap(target, this);
    }

    /**
     * setProperties:
     * 将插件注册时的property属性设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息:" + properties);
    }
}
