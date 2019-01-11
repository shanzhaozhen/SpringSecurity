package org.shanzhaozhen.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("public/login");
        registry.addViewController("/test1").setViewName("admin/starter");
        registry.addViewController("/test2").setViewName("admin/starter2");
//        registry.addViewController("/register").setViewName("public/register");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);                                  //过滤时优先执行
    }

}
