/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.jpa.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
@Entity
public class Book {
    @Id 
    String isbn;
    
    
    String title;
    @OneToMany(mappedBy = "book")
    List<BookInstance> instances;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<BookInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<BookInstance> instances) {
        this.instances = instances;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title  + '}';
    }

    
    
}
