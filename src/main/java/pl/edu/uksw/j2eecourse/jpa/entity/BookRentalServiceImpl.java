/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.jpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
@Service
public class BookRentalServiceImpl implements BookRentalService{
    @PersistenceContext 
    EntityManager entityManager;
    

    @Override
    @Transactional
    public void initDatabase() {
        registerUser("Ala");
        registerUser("Bartosz");
        registerBook("Biały kieł", "123", 2);
        registerBook("Władca Pierścieni", "1234", 10);
    }

    @Override
    @Transactional
    public User registerUser(String name) {
        User u = new User();
        u.setName(name);
        entityManager.persist(u);
        return u;
    }

    @Override
    @Transactional
    public Book registerBook(String title, String isbn, int instanceCount) {
        Book b = new Book();
        b.setTitle(title);
        b.setIsbn(isbn);
        b.setInstances(new ArrayList<BookInstance>());
        for (int i = 0; i < instanceCount; i++) {
            BookInstance bi = new BookInstance();
            b.getInstances().add(bi);
        }
        entityManager.persist(b);
        return b;
    }

    @Override
    public List<User> listUsers() {
        Query q = entityManager.createQuery("Select u from User u");
        return q.getResultList();
    }

    @Override
    public List<Book> listBooks() {
        Query q = entityManager.createQuery("Select b from Book b");
        return q.getResultList();
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rentBook(User user, Book book, Date rentDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void returnBook(Rental rental, Date returnDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rental> listOvertimeRentals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
