package com.example.praktyki1.service;


import com.example.praktyki1.dto.BookDTO;
import com.example.praktyki1.entity.Book;
import com.example.praktyki1.mapper.BookMapper;
import com.example.praktyki1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(BookMapper::toDTO).orElse(null);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookRequest) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setName(bookRequest.getName());
            book.setAuthor(bookRequest.getAuthor());
            book.setYear(bookRequest.getYear());
            book.setPublisher(bookRequest.getPublisher());
            book.setPrice(bookRequest.getPrice());
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

}
