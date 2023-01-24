//package io.sample.learn.config;
//
//import io.sample.learn.jwt.JwtAuthenticationFilter;
//import io.sample.learn.jwt.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@RequiredArgsConstructor
//
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//
//    // 암호화에 필요한 PasswordEncoder 를 Bean 등록합니다.
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
////    }
//    @Bean
//    public BCryptPasswordEncoder  passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
//        return authConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasRole("USER")
//                .requestMatchers("/**").permitAll()
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter((jwtTokenProvider)),
//                        UsernamePasswordAuthenticationFilter.class);
////
////        http
////                .formLogin()
////                .loginPage("/member/login")
////                .defaultSuccessUrl("/")
////                .usernameParameter("userId")
////
////                .passwordParameter("password")
////                .loginProcessingUrl("/login");
//
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**");
//    }
//
//
//}