package com.example.praktyki1.mapper;

import com.example.praktyki1.dto.BookDTO;
import com.example.praktyki1.dto.AuthorDTO;
import com.example.praktyki1.entity.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        if (book == null) return null;

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setYear(book.getYear());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPrice(book.getPrice());

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(book.getAuthor().getId());
        authorDTO.setName(book.getAuthor().getName());
        authorDTO.setNationality(book.getAuthor().getNationality());

        bookDTO.setAuthor(authorDTO);
        return bookDTO;
    }
}
