package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookService.findAll());

        return "books";
    }
}
