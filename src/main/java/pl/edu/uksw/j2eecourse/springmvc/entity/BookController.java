package pl.edu.uksw.j2eecourse.springmvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRentalService bookRentalService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        System.out.println("Witamy w bibliotece!");

        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView listBooks() {

        ModelAndView modelAndView = new ModelAndView("list-books");
        List<Book> books = bookRentalService.listBooks();
        modelAndView.addObject("books", books);

        return modelAndView;
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.GET)
    public ModelAndView createBook() {

        ModelAndView modelAndView = new ModelAndView("create-book");
        modelAndView.addObject("book", new Book());

        return modelAndView;
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {

        bookRentalService.registerBook(book);

        return "redirect:/books";
    }

}
