package com.example.praktyki1.service;

import com.example.praktyki1.dto.AuthorDTO;
import com.example.praktyki1.entity.Author;
import com.example.praktyki1.mapper.AuthorMapper;
import com.example.praktyki1.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::toDTO)
                .orElse(null);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
