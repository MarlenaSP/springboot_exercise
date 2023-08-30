package com.example.restapi.controller;

import com.example.restapi.controller.dto.PostDto;
import com.example.restapi.model.Post;
import com.example.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pagesNumber=0;
        if(page==null){
             pagesNumber = 0;
        } else pagesNumber = page.intValue();

        return PostDtoMapper.mapToPostDtos(postService.getPosts(pagesNumber, sort));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComment(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pagesNumber= page >= 0 ? page : 0;
        return postService.getPostsWithComments(pagesNumber, sort);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id){
        return postService.getSinglePost(id);
    }
}
