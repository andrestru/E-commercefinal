package co.com.mini.ecommerce.InfrastructureOrder.Configuration;

import co.com.mini.ecommerce.ApplicationOrder.Ports.In.*;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.ApplicationOrder.Service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OrderApplicationConfiguration {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepository orderRepository){
        return new CreateOrderService(orderRepository);
    }

    @Bean
    public ListOrderUseCase listOrderUseCase(OrderRepository orderRepository){
        return new ListOrderService(orderRepository);
    }

    @Bean
    public ListNumOrderUseCase listNumOrderUseCase(OrderRepository orderRepository){
        return new ListNumOrderService(orderRepository);
    }

    @Bean
    public EditOrderUseCase editOrderUseCase(OrderRepository orderRepository){
        return new EditOrderService(orderRepository);
    }

    @Bean
    public ListCCOrderUseCase listCCOrderUseCase(OrderRepository orderRepository){
        return new ListCcOrderService(orderRepository);
    }

    @Bean
    public WebMvcConfigurer corsConfigurerorder() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/order").allowedOrigins("http://localhost:4200/").allowedMethods("GET", "POST","PUT", "DELETE").maxAge(3600);
            }
        };
    }



}
