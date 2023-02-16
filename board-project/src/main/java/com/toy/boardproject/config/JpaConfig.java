package com.toy.boardproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing // JpaAuditing 기능 활성화
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        // JpaAuditing 을 할 때마다 사람 이름은 아래의 이름으로 들어가게 된다.
        return ()-> Optional.of("jieon"); // TODO: spring security 로 인증 기능을 붙일 때, 수정.
    }
}
