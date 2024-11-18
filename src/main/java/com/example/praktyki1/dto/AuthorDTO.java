package com.example.praktyki1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private String nationality;
    @JsonIgnoreProperties("author")
    private List<BookDTO> books;
}
