package com.chyld.controllers;

import com.chyld.models.Person;
import com.chyld.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping({"/persons"})
public class PersonsController {
    private PersonRepository repo;

    @Autowired
    public void setRepo(PersonRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Person> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page){
        PageRequest pr = new PageRequest(page, 3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person show(@PathVariable int id){
        return repo.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Person create(@RequestBody Person Person){
        return repo.save(Person);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        repo.delete(id);
    }


}
