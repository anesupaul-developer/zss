package com.test.zss.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Optional<Book> getBook(Long bookId) {
        return this.bookRepository.findById(bookId);
    }

    public List<Book> getByCategory(Long categoryId) {
        return this.bookRepository.findBookByCategoryId(categoryId);
    }

    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    public void editBook(Long bookId, Book book) {
        Optional<Book> exists = this.bookRepository.findById(bookId);
        if (exists.isEmpty()) {
            throw new IllegalStateException("Book does not exist");
        }

        Book editedBook = exists.get();
        editedBook.setTitle(book.getTitle());
        editedBook.setDescription(book.getDescription());
        editedBook.setPrice(book.getPrice());
        editedBook.setCategory(book.getCategory());
        this.bookRepository.save(editedBook);
    }

    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }
}
