package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    Integer AuthorId;
    @Column(name = "PERSON_ID")
    Integer PersonId;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "author",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    List<Book> booksList=new ArrayList<>();

    public void add(Book tempBook){
        if (booksList==null){
            booksList=new ArrayList<>();
        }
        // this is bi-directional relationship
        booksList.add(tempBook);
        tempBook.setAuthor(this);

    }

    public Integer getAuthorId() {
        return AuthorId;
    }
    public void setAuthorId(Integer AuthorId) {
        this.AuthorId = AuthorId;
    }

    public void setAPersonId(Integer PersonId) {
        this.PersonId = PersonId;
    }
    public Integer getPersonId() {
        return PersonId;
    }


    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
