/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.uksw.j2eecourse.entity.Book;
import pl.edu.uksw.j2eecourse.entity.User;
import pl.edu.uksw.j2eecourse.service.BookRentalService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
@Component
public class PersistenceExample {

    @Autowired
    BookRentalService bookRentalService;

    @PostConstruct
    public void doRunTest() {
        bookRentalService.initDatabase();
        System.out.println("Lista książek:");
        listBooks();
        System.out.println("Lista użytkowników:");
        listUsers();
        bookRentalService.registerUser("Zygmunt");
        System.out.println("Po dodaniu użytkownika:");
        listUsers();
    }

    private void listBooks() {
        List<Book> book = bookRentalService.listBooks();
        for (Book b : book) {
            System.out.println(b.toString());
        }
    }

    private void listUsers() {
        List<User> users = bookRentalService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
