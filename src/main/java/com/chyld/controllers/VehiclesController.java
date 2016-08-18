package com.chyld.controllers;


import com.chyld.models.Vehicle;
import com.chyld.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping({"/vehicles"})
public class VehiclesController {

    private VehicleRepository repo;

    @Autowired
    public void setRepo(VehicleRepository repo) { this.repo = repo; }


    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Vehicle> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page){
        PageRequest pr = new PageRequest(page, 3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Vehicle show(@PathVariable int id){
        return repo.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicle) { return repo.save(vehicle); }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        repo.delete(id);
    }


}
