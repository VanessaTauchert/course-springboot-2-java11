package com.projetospring.course.config;

import com.projetospring.course.entities.Category;
import com.projetospring.course.entities.Order;
import com.projetospring.course.entities.Product;
import com.projetospring.course.entities.User;
import com.projetospring.course.entities.enums.OrderStatus;
import com.projetospring.course.repositories.CategoryRepository;
import com.projetospring.course.repositories.OrderRepository;
import com.projetospring.course.repositories.ProductRepository;
import com.projetospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Lord of the Rings", "aaaaaaaaaaaaaaaaaaaaa", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "bbbbbbbbbbbbbbbbbbbbb", 130.5, "");
        Product p3 = new Product(null, "PC Gamer", "ccccccccccccccccccccc", 850.5, "");
        Product p4 = new Product(null, "Poliana", "ddddddddddddddddddddd", 630.5, "");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll((Arrays.asList(p1, p2, p3, p4)));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c1);
        p3.getCategories().add(c3);
        p4.getCategories().add(c2);

        productRepository.saveAll((Arrays.asList(p1, p2, p3, p4)));

        User u1 = new User(null, "Vanessa", "teste1@teste.com", "99999999", "123456");
        User u2 = new User(null, "Kerstin", "teste2@teste.com", "88888888", "123456");

        Order o1 = new Order(null, Instant.parse("2019-01-20T00:00:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-06-20T00:00:00Z"),OrderStatus.WAITING_PAYMENT, u2);





        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));




    }
}
