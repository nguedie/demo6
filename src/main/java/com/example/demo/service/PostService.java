package com.example.demo.service;

import com.example.demo.dto.CreatePostDto;
import com.example.demo.dto.UpdatePostDto;
import com.example.demo.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    Post creer(CreatePostDto createPostDto);

    Post lire(long id);

    List<Post> lire();

    Post modifier(Long id, UpdatePostDto updatePostDto);

    Long calculateTotalOccupiedTime(Post post);


    String suprimer(long id);
}
