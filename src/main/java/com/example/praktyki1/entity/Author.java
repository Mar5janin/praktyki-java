package com.example.praktyki1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;

//    @OneToOne(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("author")
//    private Book book;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("author")
    private List<Book> books;
}
