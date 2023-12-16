package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "PERSON_NAME")
    String personName;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    List<Book> booksList=new ArrayList<>();

    public void add(Book tempBook){
        if (booksList==null){
            booksList=new ArrayList<>();
        }
        // this is bi-directional relationship
        booksList.add(tempBook);
        tempBook.setPerson(this);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
