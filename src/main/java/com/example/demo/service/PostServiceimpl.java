package com.example.demo.service;

import com.example.demo.Utilite.Utils;
import com.example.demo.dto.CreatePostDto;
import com.example.demo.dto.UpdatePostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
@Service

public class PostServiceimpl  implements PostService{
    private final Utils utils;
    private  final PostRepository postRepository;

    public PostServiceimpl(Utils utils, PostRepository postRepository){
        this.utils = utils;
        this.postRepository=postRepository;
    }
    @Override
    public Post creer(CreatePostDto createPostDto) {
           /* LocalDateTime heureArrivee=LocalDateTime.now();
        int offsetInMinutes = randomOffsetBetween(0, 480); // 480 minutes = 8 hours
        LocalDateTime heureDepart = heureArrivee.plusMinutes(offsetInMinutes);
        Post post = Post.builder()
                .description(createPostDto.getDescription())
                .niveau(createPostDto.getNiveau())
                .lieu(createPostDto.getLieu())
                .build();
        return postRepository.save(post);*/
/*
        }
    private int randomOffsetBetween(int min, int max) {
        return (int) (Math.random() * (max - min) + min);*/
        Post post = new Post();
        post.setPostId(createPostDto.getPostId());
        post.setDescription(createPostDto.getDescription());
        post.setNiveau(createPostDto.getNiveau());
        post.setLieu(createPostDto.getLieu());

        // Set default heureArrive and heureDepart
        /*LocalDateTime now = LocalDateTime.now();
        post.setHeureArrivee(now.withHour(9).withMinute(0).withSecond(0)); // 9:00 AM
        post.setHeureDepart(now.withHour(17).withMinute(0).withSecond(0)); // 5:00 PM
*/
        // Set heureArrive and heureDepart from the request if provided

        if (createPostDto.getHeureArrivee() != null) {
           // post.setHeureArrivee(utils.convertDataObjectFromJsonString(createPostDto.getHeureArrivee(), LocalDateTime.class));
            post.setHeureArrivee(utils.convertStringToLocalDateTime(createPostDto.getHeureArrivee()));
        } else {
            // Set default heureArrive if not provided
            post.setHeureArrivee(LocalDateTime.now().withHour(9).withMinute(0).withSecond(0));
        }

        if (createPostDto.getHeureDepart() != null) {
            //post.setHeureDepart(utils.convertDataObjectFromJsonString(createPostDto.getHeureDepart(), LocalDateTime.class));
            post.setHeureDepart(utils.convertStringToLocalDateTime(createPostDto.getHeureDepart()));
        } else {
            // Set default heureDepart if not provided
            post.setHeureDepart(LocalDateTime.now().withHour(17).withMinute(0).withSecond(0));
        }
        return postRepository.save(post);
    }

    @Override
    public Post lire(long id) {
        var post =  postRepository.findById(id);
        return  post;
    }

    @Override
    public List<Post> lire() {
        return postRepository.findAll();
    }

    @Override
    public Post modifier(Long id, UpdatePostDto updatePostDto) {
        Optional<Post> post1=  postRepository.findById(id);

        if(post1.isPresent()){
            Post post2 = post1.get();
            post2.setDescription(updatePostDto.getDescription());
            post2.setNiveau(updatePostDto.getNiveau());
            post2.setLieu(updatePostDto.getLieu());
          //  post2.setTypeContrat(updatePostDto.getTypeContrat());
          return  postRepository.save(post2);
        }else {
           // System.out.println("personnel pas trouvee");
            throw new RuntimeException("pas de reponse trouve!!!");
        }
    }

    @Override
    public Long calculateTotalOccupiedTime(Post post) {
        var heureArrive = post.getHeureArrivee();
        var heureDepart = post.getHeureDepart();

        if (heureArrive != null && heureDepart != null) {
            Duration duration = Duration.between(heureArrive, heureDepart);
            return duration.toMinutes(); // returns the total occupied time in minutes
        } else {
            return null; // or throw an exception if you want
        }
    }

    @Override
    public String suprimer(long id) {
        postRepository.deleteById(id);
        return "post suprimer !!!";
    }
}
