package com.start.startcore.config;

import com.start.startcore.plugins.VersionInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis相关配置.
 *
 * @version 1.0
 * @author huangw 2020-05-30
 */
@Configuration
public class MyBatisConfig {

    /**
     * Mapper扫描配置. 自动扫描将Mapper接口生成代理注入到Spring.
     */
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 注意这里的扫描路径: 1.不要扫描到自定义的Mapper; 2.定义的路径不要扫描到tk.mybatis.mapper(如定义**.mapper).
        // 两个做法都会导致扫描到tk.mybatis的Mapper，就会产生重复定义的报错.
        mapperScannerConfigurer.setBasePackage("**.start.**.mapper");
        return mapperScannerConfigurer;
    }

    /**
     * 添加乐观锁version处理插件
     * @return
     */
    @Bean
    public VersionInterceptor versionInterceptor(){
        return new VersionInterceptor();
    }

}
