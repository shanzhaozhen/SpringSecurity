package org.shanzhaozhen.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MySuccessHandler mySuccessHandler;

//    @Autowired
//    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    /**
     * 定义认证规则
     * antMatchers: 允许所有用户访问"/"和"/index.html"
     * anyRequest().authenticated(): 其他地址的访问均需验证权限
     * formLogin: 表单登陆
     * loginPage: 登陆页设置
     *
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
            .authorizeRequests()
                .antMatchers("/", "/login", "/register/**", "/druid/**", "/webjars/**", "upload", "/upload/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
//                .failureUrl("login?error=true")
                .defaultSuccessUrl("/admin/index")
                .successHandler(mySuccessHandler)
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .and()
            .csrf()
                .ignoringAntMatchers("/druid/*", "/upload")
                .and()
            .rememberMe()
        ;

    }

    /**
     * 定义授权规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring().antMatchers("/webjars/**");
    }
}
