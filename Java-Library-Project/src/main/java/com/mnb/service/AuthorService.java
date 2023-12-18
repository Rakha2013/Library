package com.mnb.service;

import com.mnb.entity.Author;
import com.mnb.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();

    public Author findByAuthorId(int theAuthorId);

    public void save(Author theAuthor);

    public void deleteByAuthorId(int theAuthorId);

    public void addBook(Author author, Book book);

    Optional<Author> getAuthor(Integer authorId);
}
