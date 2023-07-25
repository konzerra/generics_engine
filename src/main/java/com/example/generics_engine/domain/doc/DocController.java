package com.example.generics_engine.domain.doc;

import com.example.generics_engine._generics.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocController {

    private final Port<Doc, Long> docPort;

    public DocController(Port<Doc, Long> docPort) {
        this.docPort = docPort;
    }


    @GetMapping("/doc/{id}")
    ResponseEntity<Doc> findById(@PathVariable long id ){


        return new ResponseEntity<>(docPort.findById(id), HttpStatus.OK);
    }
    @GetMapping("/doc/all")
    ResponseEntity<List<Doc>> findAll(){

        return new ResponseEntity<>(docPort.findAll(), HttpStatus.OK);
    }
    @GetMapping("/doc/save")
    ResponseEntity<Doc> save(@PathVariable long id ){
        return new ResponseEntity<>(docPort.save(new Doc(null, "My Title")), HttpStatus.OK);
    }
}
