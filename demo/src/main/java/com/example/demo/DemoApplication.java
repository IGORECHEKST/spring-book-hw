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
            Book bookShadows = new Book(
                    null, "Shadows of Forgotten Ancestors"
                    , "Mykhailo Kotsiubynsky"
                    , "978-617-690-336-1"
                    , new BigDecimal("450.00")
                    , "A classic story of Hutsul life and tragic love."
                    , "shadows_ancestors.jpg"
            );

            Book bookForestSong = new Book(
                    null, "Forest Song"
                    , "Lesya Ukrainka", "978-966-03-7981-5"
                    , new BigDecimal("380.00")
                    , "A poetic drama about the relationship between a man and a mythical creature."
                    , "forest_song.jpg"
            );

            bookService.save(bookShadows);
            bookService.save(bookForestSong);
        };
    }
}
