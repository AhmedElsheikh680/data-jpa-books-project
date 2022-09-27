package com.book.controller;


import com.book.dto.BookDTO;
import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
      Book book =   bookService.findById(id);
      BookDTO bookDTO = new BookDTO();
      bookDTO.setId(book.getId());
      bookDTO.setName(book.getName());
      bookDTO.setSalary(book.getSalary());
      bookDTO.setAuthor(book.getAuthor());

      return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deletebyAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
    }

















}
