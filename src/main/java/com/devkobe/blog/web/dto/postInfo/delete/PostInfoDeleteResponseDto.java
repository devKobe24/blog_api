package com.devkobe.blog.web.dto.postInfo.delete;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostInfoDeleteResponseDto {

    private Long postInfoId;

    @Builder
    public PostInfoDeleteResponseDto(Long postInfoId) {
        this.postInfoId = postInfoId;
    }
}
