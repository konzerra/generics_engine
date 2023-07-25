package com.example.generics_engine.domain.note;

import com.example.generics_engine._generics.Port;
import com.example.generics_engine.domain.doc.Doc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private final Port<Note, Long> port;

    public NoteController(Port<Note, Long> port) {
        this.port = port;
    }


    @GetMapping("/note/{id}")
    ResponseEntity<Note> findById(@PathVariable long id ){


        return new ResponseEntity<>(port.findById(id), HttpStatus.OK);
    }
    @GetMapping("/note/all")
    ResponseEntity<List<Note>> findAll(){

        return new ResponseEntity<>(port.findAll(), HttpStatus.OK);
    }
    @GetMapping("/note/save")
    ResponseEntity<Note> save(@PathVariable long id ){
        return new ResponseEntity<>(port.save(new Note(null, "My Title")), HttpStatus.OK);
    }
}
