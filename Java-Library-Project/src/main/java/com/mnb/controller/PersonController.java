package com.mnb.controller;

import com.mnb.entity.Person;
import com.mnb.service.PersonService;
import com.mnb.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonController {

    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    final BookService bookService;
    final PersonService personService;

    public PersonController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }


    @GetMapping("/list")
    public String listPersons(Model theModel) {
        // get author from db
        List<Person> thePerson = personService.findAll();
        // add to the spring model
        theModel.addAttribute("persons", thePerson);
        return "list-persons";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Person thePerson = new Person();
        theModel.addAttribute("persons", thePerson);
        return "person-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("personId") int theID, Model theModel) {
        //get the person from the service
        Person thePerson = personService.findById(theID);
        //set author as a model attribute to pre-populate the form
        theModel.addAttribute("persons", thePerson);
        return "person-form";
    }
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("persons") Person thePerson) {
        // save the author
        personService.save(thePerson);
        // use a redirect to prevent duplicate submissions
        return "redirect:/person/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("personId") int theId) {
        // delete the author
        personService.deleteById(theId);
        // redirect to /person/list
        return "redirect:/person/list";
    }
}
