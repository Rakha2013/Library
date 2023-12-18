package com.mnb.service;

import com.mnb.entity.Book;
import com.mnb.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<Person> findAll();

    public Person findByPersonId(int thesPersonId);

    public void save(Person thePerson);

    public void deleteByPersonId(int thePersonId);


    Optional<Person> getPersonId(Integer PersonId);

    void addBook(Person person, Book book);
}
