package com.mnb.service;

import com.mnb.entity.Book;
import com.mnb.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<Person> findAll();

    public Person findById(int theId);

    public void save(Person thePerson);

    public void deleteById(int theId);


    Optional<Person> getPerson(Integer personId);

    void addBook(Person person, Book book);
}
