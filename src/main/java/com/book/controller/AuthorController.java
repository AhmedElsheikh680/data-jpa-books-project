package com.book.controller;


import com.book.entity.Author;
import com.book.entity.AuthorSearch;
import com.book.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Tag(name = "Author Controller")
@RestController
@RequestMapping("")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author/{id}")
    @Operation(summary = "Find Author By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book Is Found",
                content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class))
                }),
            @ApiResponse(responseCode = "400", description = "Invalid ID Supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Author Not Found", content = @Content)
    })
    public ResponseEntity<?> findById(@Parameter(example = "20", name = "Author ID") @Min(value = 1) @Max(value = 50)@PathVariable  Long id) {

        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("/author")
    @Operation(summary="FInd All Authors")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Find Author By Email")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(authorService.findByEmail(email));
    }

    @PostMapping("author-specification")
    public ResponseEntity<?> findByAuthorSpecification(@RequestBody AuthorSearch authorSearch) {
        return ResponseEntity.ok(authorService.findByAuthorSpecification(authorSearch));
    }

    @PostMapping("/author")
    @Operation(summary = "Add New Author")
    public ResponseEntity<?> save(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/author")
    @Operation(summary = "Update AUthor")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/author/{id}")
    @Operation(summary = "Delete Author")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.ok(null);
    }



















}
