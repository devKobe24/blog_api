package com.devkobe.blog.web.dto.post.read;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostReadResponseDto {

    private Long postId;
    private PostInfo postInfo;
    private UserInfo userInfo;
    private DateInfo dateInfo;

    public PostReadResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.postInfo = entity.getPostInfo();
        this.userInfo = entity.getUserInfo();
        this.dateInfo = entity.getDateInfo();
    }
}
