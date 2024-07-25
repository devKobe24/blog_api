package com.devkobe.blog.web.dto.post.read;

import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.web.dto.dateInfo.DateInfoDto;
import com.devkobe.blog.web.dto.postInfo.PostInfoDto;
import com.devkobe.blog.web.dto.userInfo.UserInfoDto;
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
    private PostInfoDto postInfo;

    @JsonProperty("userInfo")
    private UserInfoDto userInfo;

    @JsonProperty("dateInfo")
    private DateInfoDto dateInfo;

    public PostReadResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.postInfo = new PostInfoDto(entity.getPostInfo());
        this.userInfo = new UserInfoDto(entity.getUserInfo());
        this.dateInfo = new DateInfoDto(entity.getDateInfo());
    }
}
