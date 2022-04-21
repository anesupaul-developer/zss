package com.test.zss.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping(path = "{bookId}")
    public Optional<Book> getBook(@PathVariable ("bookId") Long bookId) {
        return this.bookService.getBook(bookId);
    }

    @RequestMapping("/category/{categoryId}")
    @GetMapping
    public List<Book> getBooksByCategory(@PathVariable ("categoryId") Long categoryId) {
        return this.bookService.getByCategory(categoryId);
    }

    @PostMapping
    public void saveBook(@RequestBody Book book) {
        this.bookService.saveBook(book);
    }

    @PatchMapping(path = "{bookId}")
    public void editBook(@PathVariable ("bookId") Long bookId, @RequestBody Book book) {
        this.bookService.editBook(bookId, book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable ("bookId") Long bookId) {
        this.bookService.deleteBook(bookId);
    }
}
