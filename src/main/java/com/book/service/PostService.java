package com.book.service;

import com.book.entity.PostDTO;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private RestTemplate restTemplate;
    private static String BASE_POST_URL= "https://jsonplaceholder.typicode.com/posts";

    public PostDTO post(Long id){
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PostDTO> post = restTemplate.getForEntity(BASE_POST_URL+"/"+id,PostDTO.class );
        return post.getBody();
    }

    public List<PostDTO> posts() {
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> posts = restTemplate.getForEntity(BASE_POST_URL, List.class);

        return posts.getBody();
    }

    public PostDTO addPost(PostDTO postDTO) {
//        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        httpHeaders.add("accept-language", "en");
        HttpEntity<PostDTO> request = new HttpEntity<>(postDTO, httpHeaders);
//        ResponseEntity<PostDTO> post = restTemplate.postForEntity(BASE_POST_URL, request, PostDTO.class);
        ResponseEntity<PostDTO> post = restTemplate.exchange(BASE_POST_URL, HttpMethod.POST, request, PostDTO.class);
        return post.getBody();
    }

    public PostDTO updatePost(PostDTO postDTO) {
//        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PostDTO> request = new HttpEntity<>(postDTO);
//        restTemplate.put(BASE_POST_URL, request);
        ResponseEntity<PostDTO> post = restTemplate.exchange(BASE_POST_URL, HttpMethod.PUT, request, PostDTO.class);
        return post.getBody();
    }

    public void deletePost(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_POST_URL+"/"+id);
    }

    public void uploadFile(String id, String pathType) {
//        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", id);
        map.add("pathType", pathType);
        map.add("file", getTestFile());

        String serverUrl = "http://localhost:8082/spring-rest/fileserver/singlefileupload/";

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, request,String.class );
    }
    String getTestFile(){
        return new File("").toString();
    }


    public void getUrlHeaders() {
//        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
       HttpHeaders httpHeaders = restTemplate.headForHeaders("");
        //    	 assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }


















}
