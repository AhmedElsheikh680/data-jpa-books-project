package com.book.service;

import com.book.entity.PostDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private static String BASE_POST_URL= "https://jsonplaceholder.typicode.com/posts";

    public PostDTO post(Long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PostDTO> post = restTemplate.getForEntity(BASE_POST_URL+"/"+id,PostDTO.class );
        return post.getBody();
    }

    public List<PostDTO> posts() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> posts = restTemplate.getForEntity(BASE_POST_URL, List.class);

        return posts.getBody();
    }

    public PostDTO addPost(PostDTO postDTO) {
        RestTemplate restTemplate =  new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        httpHeaders.add("accept-language", "en");
        HttpEntity<PostDTO> request = new HttpEntity<>(postDTO, httpHeaders);
        ResponseEntity<PostDTO> post = restTemplate.postForEntity(BASE_POST_URL, request, PostDTO.class);
        return post.getBody();
    }


    public void updatePost(PostDTO postDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PostDTO> request = new HttpEntity<>(postDTO);
        restTemplate.put(BASE_POST_URL, request);
    }

    public void deletePost(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_POST_URL+"/"+id);
    }

















}
