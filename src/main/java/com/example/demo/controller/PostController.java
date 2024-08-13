package com.example.demo.controller;

import com.example.demo.dto.CreatePostDto;
import com.example.demo.dto.UpdatePostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController

@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    public PostController(PostService postService, PostRepository postRepository){
        this.postService=postService;
        this.postRepository = postRepository;
    }

    @PostMapping("/create")
    public ResponseEntity <Post>create(@RequestBody CreatePostDto createPostDto) {
        Post post = postService.creer(createPostDto);
        return ResponseEntity.ok(post);
        }



    @GetMapping("/read")
    public List<Post> read() {
        return postService.lire();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id) {
        return postService.lire(id);

    }

    @GetMapping("/posts/{id}/occupied-time")
    public Long getOccupiedTime(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return postService.calculateTotalOccupiedTime(post);
    }
    @PutMapping("/update/{id}")
    public Post update(@PathVariable long id, @RequestBody UpdatePostDto updatePostDto){
        return postService.modifier(id,updatePostDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        postService.suprimer(id);
    }



}
