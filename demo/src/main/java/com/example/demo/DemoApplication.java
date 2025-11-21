package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookService bookService) {
        return args -> {
            Book bookShadows = new Book();
            bookShadows.setTitle("Shadows of Forgotten Ancestors");
            bookShadows.setAuthor("Mykhailo Kotsiubynsky");
            bookShadows.setIsbn("978-617-690-336-1");
            bookShadows.setPrice(new BigDecimal("450.00"));
            bookShadows.setDescription("A classic story of Hutsul life and tragic love.");
            bookShadows.setCoverImage("shadows_ancestors.jpg");

            Book bookForestSong = new Book();
            bookForestSong.setTitle("Forest Song");
            bookForestSong.setAuthor("Lesya Ukrainka");
            bookForestSong.setIsbn("978-966-03-7981-5");
            bookForestSong.setPrice(new BigDecimal("380.00"));
            bookForestSong.setDescription("A poetic drama about the relationship "
                    + "between a man and a mythical creature.");
            bookForestSong.setCoverImage("forest_song.jpg");

            bookService.save(bookShadows);
            bookService.save(bookForestSong);
        };
    }
}
