package com.example.mbp0626.config;


//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//mybatis plus配置类
@Configuration
@MapperScan("com.example.mbp0626.dao")
public class MbpConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     * 3.3.2版本 cant resolve symbol
     * 3.1.0可以使用
     */

//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//
//        return new PerformanceInterceptor()
//                .setMaxTime(1);//maxTime SQL 执行最大时长，超过自动停止运行
//    }
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
