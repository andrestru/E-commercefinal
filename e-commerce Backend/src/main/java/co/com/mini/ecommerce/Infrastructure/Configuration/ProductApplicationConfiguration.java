package co.com.mini.ecommerce.Infrastructure.Configuration;

import co.com.mini.ecommerce.Application.Ports.In.CreateProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.EditProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.IdProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.ListProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import co.com.mini.ecommerce.Application.Service.CreateProductService;
import co.com.mini.ecommerce.Application.Service.EditProductService;
import co.com.mini.ecommerce.Application.Service.IdProductService;
import co.com.mini.ecommerce.Application.Service.ListProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProductApplicationConfiguration {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository){
        return new CreateProductService(productRepository);
    }

    @Bean
    public ListProductUseCase listProductUseCase(ProductRepository productRepository){
        return new ListProductService(productRepository);
    }

    @Bean
    public IdProductUseCase IdProductUseCase(ProductRepository productRepository){
        return new IdProductService(productRepository);
    }

    @Bean
    public EditProductUseCase createProductUseCaseedit(ProductRepository productRepository){
        return new EditProductService(productRepository);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/product").allowedOrigins("http://localhost:4200/").allowedMethods("GET", "POST","PUT", "DELETE").maxAge(3600);
            }
        };
    }

}
