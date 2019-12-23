package ru.geekbrains.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.persist.repo.ProductRepository;
import ru.geekbrains.persist.repo.RoleRepository;
import ru.geekbrains.persist.repo.UserRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository,
                                   BCryptPasswordEncoder passwordEncoder) {
        return new UserServiceJpaImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartService cartService() {
        return new CartServiceImpl();
    }
}
