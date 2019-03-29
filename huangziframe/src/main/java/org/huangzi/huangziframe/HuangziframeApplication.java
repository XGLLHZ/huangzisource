package org.huangzi.huangziframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan("org.huangzi.huangziframe.mapper")
public class HuangziframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuangziframeApplication.class, args);
    }

}

