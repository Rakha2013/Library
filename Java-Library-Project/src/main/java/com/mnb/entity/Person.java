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
    private
    Integer id;
    @Column(name = "FIRST_NAME")
    private
    String FirstName;
    @Column(name = "MIDDLE_NAME")
    private
    String MiddleName;
    @Column(name = "LAST_NAME")
    private
    String LastName;
    @Column(name = "ADDRESS")
    private
    String Address;
    @Column(name = "COUNTRY")
    private
    String Country;
    @Column(name = "BIRTHDAY")
    private
    String Birthday;
    @Column(name = "EMAIL")
    private
    String Email;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private
    List<Book> booksList=new ArrayList<>();

    public void add(Book tempBook){
        if (getBooksList() ==null){
            setBooksList(new ArrayList<>());
        }
        // this is bi-directional relationship
        getBooksList().add(tempBook);
        tempBook.setPerson(this);

    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }
    public String getMiddleName() {
        return MiddleName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getAddress() {
        return Address;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
    public String getBirthday() {
        return Birthday;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }
    public String getCountry() {
        return Country;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getEmail() {
        return Email;
    }
}
