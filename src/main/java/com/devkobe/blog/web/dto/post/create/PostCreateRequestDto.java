package com.devkobe.blog.web.dto.post.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.service.postList.PostListService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {

    private Long postId;
    private PostInfo postInfo;
    private UserInfo userInfo;
    private DateInfo dateInfo;

    @Builder
    public PostCreateRequestDto(
        Long postId,
        PostInfo postInfo,
        UserInfo userInfo,
        DateInfo dateInfo
    ) {
        this.postId = postId;
        this.postInfo = postInfo;
        this.userInfo = userInfo;
        this.dateInfo = dateInfo;
    }

    public Post toEntity() {
        return Post.builder()
                   .postInfo(postInfo)
                   .userInfo(userInfo)
                   .dateInfo(dateInfo)
                   .build();
    }

    // Add merge method to manage existing entities
    public Post toEntityWithMerge(PostListService service) {
        Post post = Post.builder()
                        .postId(postId)
                        .postInfo(service.mergePostInfo(postInfo))
                        .userInfo(service.mergeUserInfo(userInfo))
                        .dateInfo(service.mergeDateInfo(dateInfo))
                        .build();
        return post;
    }
}
