package com.example.generics_engine._generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class Port<Model, Id> {
    private final GenericRepository<Model, Id> repository;

    public Port(GenericRepository<Model, Id> repository) {
        this.repository = repository;
    }

    public Model save(Model model){
        return repository.save(model);
    };

    public Model findById(Id id){
        return repository.findById(id).orElseThrow();
    }

    public List<Model> findAll(){
        return repository.findAll();
    }
}
