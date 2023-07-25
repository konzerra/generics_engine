package com.example.generics_engine._generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<Model, Id> extends JpaRepository<Model, Id> {
}
