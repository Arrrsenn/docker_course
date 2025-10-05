package my.main.app.rest.config;

import my.main.app.rest.repository.UserRepository;
import my.main.app.rest.service.UserInfoService;
import my.main.app.rest.service.impl.UserInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserInfoService userInfoServiceImpl(UserRepository userRepository) {
        return new UserInfoServiceImpl(userRepository);
    }
}
