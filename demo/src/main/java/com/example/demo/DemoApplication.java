package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import java.math.BigDecimal;
import java.util.List;
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
            System.out.println("--- Запуск CommandLineRunner: Тестирование BookService ---");

            Book book1 = new Book(
                    null,
                    "Гарри Поттер и Философский камень",
                    "Джоан Роулинг",
                    "978-5-389-07498-8",
                    new BigDecimal("599.99"),
                    "Первая книга о приключениях Гарри Поттера.",
                    "cover1.jpg"
            );
            bookService.save(book1);
            System.out.println("Сохранена книга: " + book1.getTitle());

            Book book2 = new Book(
                    null,
                    "Властелин колец: Братство Кольца",
                    "Дж. Р. Р. Толкин",
                    "978-5-17-024887-1",
                    new BigDecimal("850.00"),
                    "Начало великой эпопеи Средиземья.",
                    "cover2.jpg"
            );
            bookService.save(book2);
            System.out.println("Сохранена книга: " + book2.getTitle());

            System.out.println("\n--- Список всех книг ---");
            List<Book> allBooks = bookService.findAll();
            allBooks.forEach(b ->
                    System.out.println("ID: " + b.getId() +
                            ", Название: " + b.getTitle() +
                            ", Автор: " + b.getAuthor())
            );
            System.out.println("-------------------------");
        };
    }
}
