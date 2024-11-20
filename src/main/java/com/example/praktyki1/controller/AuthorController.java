package com.example.praktyki1.controller;

import com.example.praktyki1.dto.AuthorDTO;
import com.example.praktyki1.entity.Author;
import com.example.praktyki1.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/author")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
    }
}
