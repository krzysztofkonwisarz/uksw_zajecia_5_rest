/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.jpa.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
public interface BookRentalService {
    /** Ładuje przykładowe dane do bazy, 5-10 książek, w losowej ilości 1-10 egzemplarzy.
     * Dodatkowo dodaje 3-4 użytkowników, oraz kilka otwartych i zamkniętych wypożyczeń
     */
    public void initDatabase();
    
    public User registerUser(String name);
    public Book registerBook(String title, String isbn, int instanceCount);
    public List<User> listUsers();
    public List<Book> listBooks();
    /** Sprawdza czy choć jeden egzemplarz książki jest dostępny */
    public boolean isBookAvailable(String isbn);
    /** Pozycza książkę użytkownikowi. Jeśli rentDate jest puste (null) używa bieżącej daty. */
    public void rentBook(User user, Book book, Date rentDate);
    /** Zwraca daną książkę */
    public void returnBook(Rental rental, Date returnDate);
    /** Listuje wszystkie wypożyczenia, które jeszcze trwają i trwają ponad dwa tygodnie */
    public List<Rental> listOvertimeRentals();
}
