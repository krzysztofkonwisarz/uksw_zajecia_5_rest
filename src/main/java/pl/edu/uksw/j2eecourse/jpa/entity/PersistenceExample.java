/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.jpa.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
public class PersistenceExample {

    BookRentalService bookRentalService;

    public PersistenceExample(BookRentalService service) {
        this.bookRentalService = service;
    }

//    EntityManager entityManager;
//
//    public void init() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_example_persistence_unit");
//        entityManager = emf.createEntityManager();
//    }
    static void showUsers() {

    }

    public static void main(String args[]) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        BookRentalService rentalServiceBean = context.getBean(BookRentalService.class);
        PersistenceExample sample = new PersistenceExample(rentalServiceBean);
        sample.doRunTest();
//        System.out.println("Hello world");
//        PersistenceExample instance = new PersistenceExample();
//        instance.init();
//        Book book = new Book();
//        book.setIsbn("123X");
//        instance.persist(book);

    }
//
//    public void persist(Object object) {
//
//        entityManager.getTransaction().begin();
//        try {
//            entityManager.persist(object);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        } finally {
//            entityManager.close();
//        }
//    }

    private void doRunTest() {

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
