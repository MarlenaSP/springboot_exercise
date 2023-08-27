package com.example.restapi.service;

import com.example.restapi.model.Post;
import com.example.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;

    public List<Post> getPosts(int page) {
        List<Post> postList = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
        List<Post> returnList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Post postD : postList) {
            String created = formatter.format(postD.getCreated());
            HashMap<String, String> post = new HashMap<>();
            post.put("id", String.valueOf(postD.getId()));
            post.put("title", String.valueOf(postD.getTitle()));
            post.put("content", String.valueOf(postD.getContent()));
            post.put("created", created);

            Post converted = convertMapToPost(post);
            returnList.add(converted);
        }
        return returnList;
    }

    private Post convertMapToPost(Map<String, String> postMap) {
        Post postObject = new Post();
        postObject.setId(Long.parseLong(postMap.get("id")));
        postObject.setTitle(postMap.get("title"));
        postObject.setContent(postMap.get("content"));
        postObject.setCreated(LocalDate.parse(postMap.get("created"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .atStartOfDay());
        return postObject;
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
