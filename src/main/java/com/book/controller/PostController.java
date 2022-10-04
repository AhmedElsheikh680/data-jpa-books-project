package com.book.controller;

import com.book.entity.PostDTO;
import com.book.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> post(@PathVariable Long id) {
       return ResponseEntity.ok( postService.post(id));
    }

    @GetMapping("")
    public ResponseEntity<?> posts() {
        return ResponseEntity.ok(postService.posts());
    }

    @PostMapping("")
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.addPost(postDTO));
    }

    @PutMapping("")
    public ResponseEntity<?> updatePost(@RequestBody PostDTO postDTO) {
        postService.updatePost(postDTO);
        return ResponseEntity.ok(null);
    }















}
