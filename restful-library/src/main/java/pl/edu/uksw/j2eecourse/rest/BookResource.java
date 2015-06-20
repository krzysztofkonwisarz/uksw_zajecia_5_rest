package pl.edu.uksw.j2eecourse.rest;

import javax.ws.rs.core.Response;

/**
 *  Dodaj adnotacje tak, aby:
 *   - BookResource było springowym beanem
 *   - BR "produkowało" i przyjmowało JSON
 *   - BR działało pod /books (docelowo pod /api/books uwzględniając konfigurację serwletu Jersey w web.xml)
 */
public class BookResource {

    // dodaj adnotację tak, aby metoda odpowiadała na żądania HTTP GET idące do /books
    public Response listBooks() {

        // pobierz z BookRentalService
        // Umieść w BookDto - każdą Book zamapuj na BookDto
        // zwróć listę BookDto przez Response

        return null; //Response.ok(bookDtos).build();
    }

    // dodaj adnotację tak, aby metoda odpowiadała na żądania HTTP POST idące do /books
    public Response addBook() { // metoda przyjmie BookDto i będzie mapowała przesyłane dane na ten obiekt, jeżeli zdefiniujesz argument tego typu
        // zarejestruj książkę, jaką otrzymujesz w żądaniu

        return Response.status(Response.Status.CREATED).build(); // odpowiadamy stanem HTTP 201 na pomyślne dodanie książki
    }

}
