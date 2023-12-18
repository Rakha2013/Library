package com.mnb.service;

import com.mnb.entity.Person;
import com.mnb.entity.Book;
import com.mnb.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService{
    final PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int theId) {
        Optional<Person> result = personRepository.findById(theId);
        Person thePerson = null;
        if (result.isPresent()) {
            thePerson = result.get();
        }
        else {
            // we didn't find the book
            throw new RuntimeException("Did not find person id - " + theId);
        }
        return thePerson;
    }

    @Override
    public void save(Person thePerson) {
        personRepository.save(thePerson);
    }

    @Override
    public void deleteById(int theId) {
        personRepository.deleteById(theId);
    }

    @Override
    public void addBook(Person person, Book book) {
        if( personRepository.findById(person.getId()).isPresent())
            personRepository.findById(person.getId()).get().getBooksList().add(book);
    }
    @Override
    public Optional<Person> getPerson(Integer personId) {
        return personRepository.findById(personId);
    }
}
