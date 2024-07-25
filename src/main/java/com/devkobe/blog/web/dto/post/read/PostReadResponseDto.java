package com.devkobe.blog.web.dto.post.read;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostReadResponseDto {

    @JsonProperty("postId")
    private Long postId;

    @JsonProperty("postInfo")
    private PostInfo postInfo;

    @JsonProperty("userInfo")
    private UserInfo userInfo;

    @JsonProperty("dateInfo")
    private DateInfo dateInfo;

    public PostReadResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.postInfo = entity.getPostInfo();
        this.userInfo = entity.getUserInfo();
        this.dateInfo = entity.getDateInfo();
    }
}
