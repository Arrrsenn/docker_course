package my.main.app.rest.config;


import my.main.app.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import my.main.app.service.UserInfoService;
import my.main.app.service.impl.UserInfoServiceImpl;


@Configuration
public class ApplicationConfig {

    @Bean
    public UserInfoService userInfoServiceImpl(UserRepository userRepository) {
        return new UserInfoServiceImpl(userRepository);
    }
}
