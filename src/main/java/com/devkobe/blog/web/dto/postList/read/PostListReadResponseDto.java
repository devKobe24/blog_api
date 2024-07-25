package com.devkobe.blog.web.dto.postList.read;

import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.web.dto.post.read.PostReadResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListReadResponseDto {

    @JsonProperty("uuid")
    private UUID uuid;
    private List<PostReadResponseDto> posts;

    public PostListReadResponseDto(PostList entity) {
        this.uuid = entity.getUuid();
        this.posts = entity
            .getPosts()
            .stream()
            .map(PostReadResponseDto::new)
            .collect(Collectors.toList());
    }

}