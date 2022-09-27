package com.book.controller;


import com.book.entity.Author;
import com.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 5) @Max(value = 100) Long id) {

        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("/author")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("/author")
    public ResponseEntity<?> save(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/author")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.ok(null);
    }



















}
