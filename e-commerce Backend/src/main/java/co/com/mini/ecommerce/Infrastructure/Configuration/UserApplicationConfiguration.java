package co.com.mini.ecommerce.Infrastructure.Configuration;

import co.com.mini.ecommerce.Application.Ports.In.UserUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.UserRepository;
import co.com.mini.ecommerce.Application.Service.LoginUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserApplicationConfiguration {

    @Bean
    public UserUseCase userUseCase(UserRepository userRepository){
        return new LoginUserService(userRepository);
    }

    @Bean
    public WebMvcConfigurer corsConfigurers() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/user").allowedOrigins("http://localhost:4200/").allowedMethods("GET", "POST","PUT", "DELETE").maxAge(3600);
            }
        };
    }


}
