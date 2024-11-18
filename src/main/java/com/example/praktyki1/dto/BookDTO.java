package com.example.praktyki1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String name;
    private int year;
    private String publisher;
    private int price;
    @JsonIgnoreProperties("books")
    private AuthorDTO author;
}
