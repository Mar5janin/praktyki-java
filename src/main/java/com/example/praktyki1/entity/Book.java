package com.example.praktyki1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int year;
    private String publisher;
    private int price;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "author_id")
//    @JsonIgnoreProperties("book")
//    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties("books")
    private Author author;
}



//{
//        "name": "W Pustyni i w puszczy",
//        "year": 1911,
//        "publisher": "Nasza Księgarnia",
//        "price": 35,
//        "author": {
//        "id": 1
//        }
//        }

//{
//        "name": "Pan Tadeusz",
//        "year": 1911,
//        "publisher": "Nasza Księgarnia",
//        "price": 35,
//        "author": {
//        "id": 2
//        }
//        }

//{
//        "name": "Dziady",
//        "year": 1911,
//        "publisher": "Nasza Księgarnia",
//        "price": 35,
//        "author": {
//        "id": 2
//        }
//        }
//
//        {
//            "name": "Henryk Sienkiewicz",
//            "nationality": "Polish"
//        }

//{
//            "name": "Adam Mickiewicz",
//            "nationality": "Polish"
//        }