package com.devkobe.blog.web.dto.post.update;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private PostInfo postInfo;
    private UserInfo userInfo;
    private DateInfo dateInfo;

    @Builder
    public PostUpdateRequestDto(
        PostInfo postInfo,
        UserInfo userInfo,
        DateInfo dateInfo
    ) {
        this.postInfo = postInfo;
        this.userInfo = userInfo;
        this.dateInfo = dateInfo;
    }
}
