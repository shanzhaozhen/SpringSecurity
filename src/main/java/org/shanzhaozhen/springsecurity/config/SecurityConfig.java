package org.shanzhaozhen.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

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
                .antMatchers("/", "/test1", "/test2", "/login", "/register/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
//                .permitAll()
                .defaultSuccessUrl("/admin/index")
//                .failureUrl("login?error=true")
//                .successHandler(new MySuccessHandler())
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .and()
//                .csrf().disable()
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


}
